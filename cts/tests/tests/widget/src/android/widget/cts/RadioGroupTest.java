/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.widget.cts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import android.app.Activity;
import android.content.Context;
import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Vector;

/**
 * Test {@link RadioGroup}.
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class RadioGroupTest {
    private Activity mActivity;
    private RadioGroup mRadioGroup;

    @Rule
    public ActivityTestRule<RadioGroupCtsActivity> mActivityRule =
            new ActivityTestRule<>(RadioGroupCtsActivity.class);

    @Before
    public void setup() {
        mActivity = mActivityRule.getActivity();
        mRadioGroup = (RadioGroup) mActivity.findViewById(R.id.radio_group);
    }

    @Test
    public void testConstructors() {
        new RadioGroup(mActivity);

        AttributeSet attrs = getAttributeSet(R.layout.radiogroup_1);
        new RadioGroup(mActivity, attrs);
        new RadioGroup(mActivity, null);
    }

    @UiThreadTest
    @Test
    public void testSetOnHierarchyChangeListener() {
        MockOnHierarchyChangeListener listener = new MockOnHierarchyChangeListener();
        mRadioGroup.setOnHierarchyChangeListener(listener);

        View button3 = mRadioGroup.findViewById(R.id.radio_button_3);
        listener.reset();
        mRadioGroup.removeView(button3);
        assertSame(mRadioGroup, listener.getOnChildViewRemovedParentParam());
        assertSame(button3, listener.getOnChildViewRemovedChildParam());

        listener.reset();
        mRadioGroup.addView(button3);
        assertSame(mRadioGroup, listener.getOnChildViewAddedParentParam());
        assertSame(button3, listener.getOnChildViewAddedChildParam());

        // Set listener to null
        mRadioGroup.setOnHierarchyChangeListener(null);
        // and no exceptions thrown in the following method calls
        mRadioGroup.removeView(button3);
        mRadioGroup.addView(button3);
    }

    @UiThreadTest
    @Test
    public void testInternalPassThroughHierarchyChangeListener() {
        RadioButton newButton = new RadioButton(mActivity);

        assertEquals(View.NO_ID, newButton.getId());
        mRadioGroup.addView(newButton, new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        // aapt-generated IDs have a nonzero high byte; check that the ID generated by
        // RadioGroup falls within a range that will not collide with aapt IDs.
        assertEquals(0, newButton.getId() & 0xFF000000);
    }

    @UiThreadTest
    @Test
    public void testInternalCheckedStateTracker() {
        RadioButton newButton = new RadioButton(mActivity);
        // inject the tracker to the button when the button is added by
        // CompoundButton#setOnCheckedChangeWidgetListener(OnCheckedChangeListener)
        mRadioGroup.addView(newButton, new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        MockOnCheckedChangeListener listener = new MockOnCheckedChangeListener();
        mRadioGroup.setOnCheckedChangeListener(listener);

        listener.reset();
        newButton.setChecked(true);
        // the tracker informs the checked state change of the button to the group
        assertHasCalledOnCheckedChanged(listener);

        listener.reset();
        // the tracker informs the checked state change of the button to the group
        newButton.setChecked(false);
        assertHasCalledOnCheckedChanged(listener);

        // remove the tracker from the button when the button is removed
        mRadioGroup.removeView(newButton);
        listener.reset();
        newButton.setChecked(true);
        assertHaveNotCalledOnCheckedChanged(listener);

        listener.reset();
        newButton.setChecked(false);
        assertHaveNotCalledOnCheckedChanged(listener);
    }

    @UiThreadTest
    @Test
    public void testGetCheckedRadioButtonId() {
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());

        mRadioGroup.check(R.id.radio_button_0);
        assertEquals(R.id.radio_button_0, mRadioGroup.getCheckedRadioButtonId());

        mRadioGroup.check(R.id.radio_button_3);
        assertEquals(R.id.radio_button_3, mRadioGroup.getCheckedRadioButtonId());

        // None of the buttons inside the group has of of the following IDs
        mRadioGroup.check(4);
        assertEquals(4, mRadioGroup.getCheckedRadioButtonId());

        mRadioGroup.check(-1);
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());

        mRadioGroup.check(-3);
        assertEquals(-3, mRadioGroup.getCheckedRadioButtonId());
    }

    @UiThreadTest
    @Test
    public void testClearCheck() {
        MockOnCheckedChangeListener listener = new MockOnCheckedChangeListener();
        mRadioGroup.setOnCheckedChangeListener(listener);

        mRadioGroup.check(R.id.radio_button_3);
        assertEquals(R.id.radio_button_3, mRadioGroup.getCheckedRadioButtonId());

        listener.reset();
        mRadioGroup.clearCheck();
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());
        assertHasCalledOnCheckedChanged(listener);
        // uncheck the original button
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, R.id.radio_button_3);

        // None of the buttons inside the group has of of the following IDs
        mRadioGroup.check(4);
        assertEquals(4, mRadioGroup.getCheckedRadioButtonId());

        listener.reset();
        mRadioGroup.clearCheck();
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());
        // why the method is called while none of the button is checked or unchecked?
        assertHasCalledOnCheckedChanged(listener);
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, -1);

        mRadioGroup.check(-1);
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());

        listener.reset();
        mRadioGroup.clearCheck();
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());
        // why the method is called while none of the button is checked or unchecked?
        assertHasCalledOnCheckedChanged(listener);
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, -1);
    }

    @UiThreadTest
    @Test
    public void testCheck() {
        MockOnCheckedChangeListener listener = new MockOnCheckedChangeListener();
        mRadioGroup.setOnCheckedChangeListener(listener);
        assertEquals(-1, mRadioGroup.getCheckedRadioButtonId());

        listener.reset();
        mRadioGroup.check(R.id.radio_button_0);
        assertHasCalledOnCheckedChanged(listener);
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, R.id.radio_button_0);

        listener.reset();
        mRadioGroup.check(R.id.radio_button_1);
        assertHasCalledOnCheckedChanged(listener);
        // uncheck the original button
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, R.id.radio_button_0);
        // check the new button
        assertOnCheckedChangedParams(listener, 1, mRadioGroup, R.id.radio_button_1);

        listener.reset();
        mRadioGroup.check(-1);
        assertHasCalledOnCheckedChanged(listener);
        // uncheck the original button
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, R.id.radio_button_1);
        assertOnCheckedChangedParams(listener, 1, mRadioGroup, -1);

        // None of the buttons inside the group has of of the following IDs
        listener.reset();
        mRadioGroup.check(-1);
        // why the method is called while none of the inside buttons has been changed
        assertHasCalledOnCheckedChanged(listener);
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, -1);

        listener.reset();
        mRadioGroup.check(4);
        // why the method is called while none of the inside buttons has been changed
        assertHasCalledOnCheckedChanged(listener);
        assertOnCheckedChangedParams(listener, 0, mRadioGroup, 4);

        // Set listener to null
        mRadioGroup.setOnCheckedChangeListener(null);
        // no exceptions thrown during the following method
        mRadioGroup.check(0);
    }

    @UiThreadTest
    @Test
    public void testSetOnCheckedChangeListener() {
        MockOnCheckedChangeListener listener = new MockOnCheckedChangeListener();
        mRadioGroup.setOnCheckedChangeListener(listener);

        listener.reset();
        mRadioGroup.check(R.id.radio_button_0);
        assertHasCalledOnCheckedChanged(listener);

        // does not call the method if the button the id is already checked
        listener.reset();
        mRadioGroup.check(R.id.radio_button_0);
        assertHaveNotCalledOnCheckedChanged(listener);

        // call the method if none of the buttons inside the group has the id
        listener.reset();
        mRadioGroup.check(-3);
        assertHasCalledOnCheckedChanged(listener);

        // does not call the method if the button the id is already checked
        // and none of the buttons inside the group has the id
        listener.reset();
        mRadioGroup.check(-3);
        assertHaveNotCalledOnCheckedChanged(listener);

        // always call the method if the checked id is -1
        listener.reset();
        mRadioGroup.clearCheck();
        assertHasCalledOnCheckedChanged(listener);

        listener.reset();
        mRadioGroup.check(-1);
        assertHasCalledOnCheckedChanged(listener);

        // Set listener to null
        mRadioGroup.setOnCheckedChangeListener(null);
        // no exceptions thrown during the following method
        mRadioGroup.check(0);
    }

    @Test
    public void testGenerateLayoutParams() {
        RadioGroup.LayoutParams layoutParams =
            mRadioGroup.generateLayoutParams((AttributeSet) null);
        assertNotNull(layoutParams);
        // default values
        assertEquals(0.0, layoutParams.weight, 0);
        assertEquals(-1, layoutParams.gravity);
        assertEquals(0, layoutParams.leftMargin);
        assertEquals(0, layoutParams.topMargin);
        assertEquals(0, layoutParams.rightMargin);
        assertEquals(0, layoutParams.bottomMargin);
        assertEquals(LayoutParams.WRAP_CONTENT, layoutParams.width);
        assertEquals(LayoutParams.WRAP_CONTENT, layoutParams.height);

        AttributeSet attrs = getAttributeSet(R.layout.radiogroup_1);
        layoutParams = mRadioGroup.generateLayoutParams(attrs);
        // values from layout
        assertNotNull(layoutParams);
        assertEquals(0.5, layoutParams.weight, 0);
        assertEquals(Gravity.BOTTOM, layoutParams.gravity);
        assertEquals(5, layoutParams.leftMargin);
        assertEquals(5, layoutParams.topMargin);
        assertEquals(5, layoutParams.rightMargin);
        assertEquals(5, layoutParams.bottomMargin);
        assertEquals(LayoutParams.MATCH_PARENT, layoutParams.width);
        assertEquals(LayoutParams.MATCH_PARENT, layoutParams.height);
    }

    @Test
    public void testCheckLayoutParams() {
        MockRadioGroup mRadioGroupWrapper = new MockRadioGroup(mActivity);

        assertFalse(mRadioGroupWrapper.checkLayoutParams(null));

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        assertFalse(mRadioGroupWrapper.checkLayoutParams(relativeParams));

        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        assertFalse(mRadioGroupWrapper.checkLayoutParams(linearParams));

        RadioGroup.LayoutParams radioParams = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.MATCH_PARENT);
        assertTrue(mRadioGroupWrapper.checkLayoutParams(radioParams));
    }

    @Test
    public void testGenerateDefaultLayoutParams() {
        MockRadioGroup radioGroupWrapper = new MockRadioGroup(mActivity);
        LinearLayout.LayoutParams p = radioGroupWrapper.generateDefaultLayoutParams();

        assertTrue(p instanceof RadioGroup.LayoutParams);
        assertEquals(RadioGroup.LayoutParams.WRAP_CONTENT, p.width);
        assertEquals(RadioGroup.LayoutParams.WRAP_CONTENT, p.height);
    }

    @UiThreadTest
    @Test
    public void testOnFinishInflate() {
        MockRadioGroup radioGroup = new MockRadioGroup(mActivity);
        int checkId = 100;
        radioGroup.check(checkId);
        // the button is added after the check(int)method
        // and it not checked though it has exactly the checkId
        RadioButton button = new RadioButton(mActivity);
        button.setId(checkId);
        radioGroup.addView(button, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        MockOnCheckedChangeListener listener = new MockOnCheckedChangeListener();
        radioGroup.setOnCheckedChangeListener(listener);

        // check the button which id is CheckedRadioButtonId
        listener.reset();
        assertFalse(button.isChecked());
        radioGroup.onFinishInflate();
        assertTrue(button.isChecked());
        assertHasCalledOnCheckedChanged(listener);
        assertEquals(checkId, radioGroup.getCheckedRadioButtonId());

        radioGroup = new MockRadioGroup(mActivity);
        button = new RadioButton(mActivity);
        radioGroup.addView(button, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        listener = new MockOnCheckedChangeListener();
        radioGroup.setOnCheckedChangeListener(listener);

        // nothing happens if checkedRadioButtonId is -1
        assertEquals(-1, radioGroup.getCheckedRadioButtonId());
        assertFalse(button.isChecked());
        listener.reset();
        radioGroup.onFinishInflate();
        assertHaveNotCalledOnCheckedChanged(listener);
        assertEquals(-1, radioGroup.getCheckedRadioButtonId());
        assertFalse(button.isChecked());
    }

    @UiThreadTest
    @Test
    public void testAddView() {
        mRadioGroup.check(R.id.radio_button_0);
        assertEquals(R.id.radio_button_0, mRadioGroup.getCheckedRadioButtonId());
        assertEquals(4, mRadioGroup.getChildCount());

        int id = R.id.radio_button_3 + 10;
        RadioButton choice4 = new RadioButton(mActivity);
        choice4.setText("choice4");
        choice4.setId(id);
        choice4.setChecked(true);
        mRadioGroup.addView(choice4, 4, new ViewGroup.LayoutParams(100, 200));
        assertEquals(id, mRadioGroup.getCheckedRadioButtonId());
        assertEquals(5, mRadioGroup.getChildCount());
    }

    private AttributeSet getAttributeSet(int resId) {
        XmlPullParser parser = mActivity.getResources().getLayout(resId);
        assertNotNull(parser);
        int type = 0;
        try {
            while ((type = parser.next()) != XmlPullParser.START_TAG
                    && type != XmlPullParser.END_DOCUMENT) {
                // Empty
            }
        } catch (XmlPullParserException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        }

        assertEquals("No RadioGroup element found", XmlPullParser.START_TAG, type);
        assertEquals("The first element is not RadioGroup", "RadioGroup", parser.getName());
        return Xml.asAttributeSet(parser);
    }

    private void assertHaveNotCalledOnCheckedChanged(MockOnCheckedChangeListener listener) {
        assertEquals(0, listener.getOnCheckedChangedGroupParams().size());
        assertEquals(0, listener.getOnCheckedChangedCheckedIdParams().size());
    }

    private void assertHasCalledOnCheckedChanged(MockOnCheckedChangeListener listener) {
        assertTrue(listener.getOnCheckedChangedGroupParams().size() > 0);
        assertTrue(listener.getOnCheckedChangedCheckedIdParams().size() > 0);
    }

    private void assertOnCheckedChangedParams(MockOnCheckedChangeListener listener, int time,
            RadioGroup paramGroup, int paramCheckedId) {
        assertSame(paramGroup,
                listener.getOnCheckedChangedGroupParams().get(time));
        assertEquals(paramCheckedId, listener
                .getOnCheckedChangedCheckedIdParams().get(time).intValue());
    }

    private class MockOnCheckedChangeListener implements OnCheckedChangeListener {
        private Vector<RadioGroup> mOnCheckedChangedGroupParams = new Vector<RadioGroup>();

        private Vector<Integer> mOnCheckedChangedCheckedIdParams = new Vector<Integer>();

        public Vector<RadioGroup> getOnCheckedChangedGroupParams() {
            return mOnCheckedChangedGroupParams;
        }

        public Vector<Integer> getOnCheckedChangedCheckedIdParams() {
            return mOnCheckedChangedCheckedIdParams;
        }

        public void reset() {
            mOnCheckedChangedGroupParams.clear();
            mOnCheckedChangedCheckedIdParams.clear();
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            mOnCheckedChangedGroupParams.add(group);
            mOnCheckedChangedCheckedIdParams.add(checkedId);
        }
    }

    private class MockOnHierarchyChangeListener implements OnHierarchyChangeListener {
        private View mOnChildViewAddedParentParam;

        private View mOnChildViewAddedChildParam;

        private View mOnChildViewRemovedParentParam;

        private View mOnChildViewRemovedChildParam;

        public View getOnChildViewAddedParentParam() {
            return mOnChildViewAddedParentParam;
        }

        public View getOnChildViewAddedChildParam() {
            return mOnChildViewAddedChildParam;
        }

        public View getOnChildViewRemovedParentParam() {
            return mOnChildViewRemovedParentParam;
        }

        public View getOnChildViewRemovedChildParam() {
            return mOnChildViewRemovedChildParam;
        }

        public void reset() {
            mOnChildViewAddedParentParam = null;
            mOnChildViewAddedChildParam = null;
            mOnChildViewRemovedParentParam = null;
            mOnChildViewRemovedChildParam = null;
        }

        public void onChildViewAdded(View parent, View child) {
            mOnChildViewAddedParentParam = parent;
            mOnChildViewAddedChildParam = child;
        }

        public void onChildViewRemoved(View parent, View child) {
            mOnChildViewRemovedParentParam = parent;
            mOnChildViewRemovedChildParam = child;
        }
    }

    public static class MockRadioGroup extends RadioGroup {
        public MockRadioGroup(Context context) {
            super(context);
        }

        @Override
        protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
            return super.checkLayoutParams(p);
        }

        @Override
        protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams() {
            return super.generateDefaultLayoutParams();
        }

        @Override
        protected void onFinishInflate() {
            super.onFinishInflate();
        }
    }
}
