// C(n, r) = C(n - 1, r - 1) + C(n - 1, r)
private long nCr(int n, int r, long mod) {
    if (r == 0) {
        return 1;
    }

    long[] memo = new long[r + 1];
    memo[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = r; j >= 1; j--) {
            memo[j] = ((memo[j] % mod) + (memo[j - 1] % mod)) % mod;
        }
    }

    return memo[r];
}
