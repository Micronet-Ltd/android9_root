#pragma version(1)
#pragma rs java_package_name(android.renderscript.cts)

rs_allocation gIn;

void root(uint32_t *out, uint32_t x) {
    const uint32_t * tm = rsGetElementAt (gIn, x);
    *out = *tm;
}