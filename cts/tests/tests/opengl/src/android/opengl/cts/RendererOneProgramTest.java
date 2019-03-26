/*
 * Copyright (C) 2012 The Android Open Source Project
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
package android.opengl.cts;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import java.util.concurrent.CountDownLatch;
import android.opengl.GLES20;
import android.util.Log;

public class RendererOneProgramTest extends RendererBase {

    public RendererOneProgramTest(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);

        mProgram =  GLES20.glCreateProgram();
        int mProgramTwo = GLES20.glCreateProgram();
        GLES20.glAttachShader(mProgram, mProgramTwo);
        mError = GLES20.glGetError();
        mLatch.countDown();
    }
}
