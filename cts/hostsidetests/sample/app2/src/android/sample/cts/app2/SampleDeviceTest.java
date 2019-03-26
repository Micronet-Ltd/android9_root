/*
 * Copyright (C) 2016 The Android Open Source Project
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

package android.sample.cts.app2;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;

/**
 * Device-side tests for CtsSampleHostTestCases
 */
@RunWith(AndroidJUnit4.class)
public class SampleDeviceTest {

    @Test
    public void testPasses() throws Exception {
        Assert.assertTrue(true);
    }

    @Test
    public void testAssumeFails() throws Exception {
        Assume.assumeTrue(false);
    }

    @Test
    public void testFails() throws Exception {
        Assert.assertTrue(false);
    }
}
