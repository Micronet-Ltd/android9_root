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

// Don't edit this file!  It is auto-generated by frameworks/rs/api/generate.sh.

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;
import android.renderscript.cts.Target;

import java.util.Arrays;

public class TestCeil extends RSBaseCompute {

    private ScriptC_TestCeil script;
    private ScriptC_TestCeilRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestCeil(mRS);
        scriptRelaxed = new ScriptC_TestCeilRelaxed(mRS);
    }

    @Override
    protected void tearDown() throws Exception {
        script.destroy();
        scriptRelaxed.destroy();
        super.tearDown();
    }

    public class ArgumentsFloatFloat {
        public float inV;
        public Target.Floaty out;
    }

    private void checkCeilFloatFloat() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0xf12a662b492bf934l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.forEach_testCeilFloatFloat(inV, out);
            verifyResultsCeilFloatFloat(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloatFloat: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.forEach_testCeilFloatFloat(inV, out);
            verifyResultsCeilFloatFloat(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloatFloat: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilFloatFloat(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloat args = new ArgumentsFloatFloat();
                args.inV = arrayInV[i];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 1 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 1 + j]);
                        if (!args.out.couldBe(arrayOut[i * 1 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilFloatFloat" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkCeilFloat2Float2() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0xdb16a3ea43152978l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            script.forEach_testCeilFloat2Float2(inV, out);
            verifyResultsCeilFloat2Float2(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloat2Float2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            scriptRelaxed.forEach_testCeilFloat2Float2(inV, out);
            verifyResultsCeilFloat2Float2(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloat2Float2: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilFloat2Float2(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 2];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloat args = new ArgumentsFloatFloat();
                args.inV = arrayInV[i * 2 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 2 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 2 + j]);
                        if (!args.out.couldBe(arrayOut[i * 2 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilFloat2Float2" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkCeilFloat3Float3() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0xdb186d0539304a56l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            script.forEach_testCeilFloat3Float3(inV, out);
            verifyResultsCeilFloat3Float3(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloat3Float3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            scriptRelaxed.forEach_testCeilFloat3Float3(inV, out);
            verifyResultsCeilFloat3Float3(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloat3Float3: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilFloat3Float3(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloat args = new ArgumentsFloatFloat();
                args.inV = arrayInV[i * 4 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilFloat3Float3" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkCeilFloat4Float4() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0xdb1a36202f4b6b34l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            script.forEach_testCeilFloat4Float4(inV, out);
            verifyResultsCeilFloat4Float4(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloat4Float4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            scriptRelaxed.forEach_testCeilFloat4Float4(inV, out);
            verifyResultsCeilFloat4Float4(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilFloat4Float4: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilFloat4Float4(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloat args = new ArgumentsFloatFloat();
                args.inV = arrayInV[i * 4 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilFloat4Float4" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public class ArgumentsHalfHalf {
        public short inV;
        public double inVDouble;
        public Target.Floaty out;
    }

    private void checkCeilHalfHalf() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 1, 0xf287e5866f7686bel, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 1), INPUTSIZE);
            script.forEach_testCeilHalfHalf(inV, out);
            verifyResultsCeilHalfHalf(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalfHalf: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 1), INPUTSIZE);
            scriptRelaxed.forEach_testCeilHalfHalf(inV, out);
            verifyResultsCeilHalfHalf(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalfHalf: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilHalfHalf(Allocation inV, Allocation out, boolean relaxed) {
        short[] arrayInV = new short[INPUTSIZE * 1];
        Arrays.fill(arrayInV, (short) 42);
        inV.copyTo(arrayInV);
        short[] arrayOut = new short[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalf args = new ArgumentsHalfHalf();
                args.inV = arrayInV[i];
                args.inVDouble = Float16Utils.convertFloat16ToDouble(args.inV);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 1 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 1 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 1 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 1 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilHalfHalf" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkCeilHalf2Half2() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 2, 0xb787d7deb64a4070l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 2), INPUTSIZE);
            script.forEach_testCeilHalf2Half2(inV, out);
            verifyResultsCeilHalf2Half2(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalf2Half2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 2), INPUTSIZE);
            scriptRelaxed.forEach_testCeilHalf2Half2(inV, out);
            verifyResultsCeilHalf2Half2(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalf2Half2: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilHalf2Half2(Allocation inV, Allocation out, boolean relaxed) {
        short[] arrayInV = new short[INPUTSIZE * 2];
        Arrays.fill(arrayInV, (short) 42);
        inV.copyTo(arrayInV);
        short[] arrayOut = new short[INPUTSIZE * 2];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalf args = new ArgumentsHalfHalf();
                args.inV = arrayInV[i * 2 + j];
                args.inVDouble = Float16Utils.convertFloat16ToDouble(args.inV);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 2 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 2 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 2 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 2 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilHalf2Half2" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkCeilHalf3Half3() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 3, 0xb787e28015520564l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 3), INPUTSIZE);
            script.forEach_testCeilHalf3Half3(inV, out);
            verifyResultsCeilHalf3Half3(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalf3Half3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 3), INPUTSIZE);
            scriptRelaxed.forEach_testCeilHalf3Half3(inV, out);
            verifyResultsCeilHalf3Half3(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalf3Half3: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilHalf3Half3(Allocation inV, Allocation out, boolean relaxed) {
        short[] arrayInV = new short[INPUTSIZE * 4];
        Arrays.fill(arrayInV, (short) 42);
        inV.copyTo(arrayInV);
        short[] arrayOut = new short[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalf args = new ArgumentsHalfHalf();
                args.inV = arrayInV[i * 4 + j];
                args.inVDouble = Float16Utils.convertFloat16ToDouble(args.inV);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilHalf3Half3" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkCeilHalf4Half4() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_16, 4, 0xb787ed217459ca58l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 4), INPUTSIZE);
            script.forEach_testCeilHalf4Half4(inV, out);
            verifyResultsCeilHalf4Half4(inV, out, false);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalf4Half4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_16, 4), INPUTSIZE);
            scriptRelaxed.forEach_testCeilHalf4Half4(inV, out);
            verifyResultsCeilHalf4Half4(inV, out, true);
            out.destroy();
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testCeilHalf4Half4: " + e.toString());
        }
        inV.destroy();
    }

    private void verifyResultsCeilHalf4Half4(Allocation inV, Allocation out, boolean relaxed) {
        short[] arrayInV = new short[INPUTSIZE * 4];
        Arrays.fill(arrayInV, (short) 42);
        inV.copyTo(arrayInV);
        short[] arrayOut = new short[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (short) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsHalfHalf args = new ArgumentsHalfHalf();
                args.inV = arrayInV[i * 4 + j];
                args.inVDouble = Float16Utils.convertFloat16ToDouble(args.inV);
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.HALF, relaxed);
                CoreMathVerifier.computeCeil(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inV: ");
                        appendVariableToMessage(message, args.inV);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        message.append("\n");
                        message.append("Actual   output out (in double): ");
                        appendVariableToMessage(message, Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]));
                        if (!args.out.couldBe(Float16Utils.convertFloat16ToDouble(arrayOut[i * 4 + j]))) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkCeilHalf4Half4" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public void testCeil() {
        checkCeilFloatFloat();
        checkCeilFloat2Float2();
        checkCeilFloat3Float3();
        checkCeilFloat4Float4();
        checkCeilHalfHalf();
        checkCeilHalf2Half2();
        checkCeilHalf3Half3();
        checkCeilHalf4Half4();
    }
}
