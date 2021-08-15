public long powerWithMod(long x, long n, long mod) {
    if (n == 0)
        return 1;

    long val = powerWithMod(x, n / 2, mod);
    if (n % 2 == 0) {
        return (val * val) % mod;
    } else {
        return (((val * val) % mod) * (x % mod)) % mod;
    }
}
