package Arrays;

class PeopleAwareOfSecret {
    static final int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        var f = new int[n];
        f[0] = 1;
        var cntB = 0;
        for (var i = 0; i < n; ++i) {
            if (i + delay >= n) cntB = (cntB + f[i]) % MOD;
            for (int j = i + delay; j < Math.min(i + forget, n); ++j)
                f[j] = (f[j] + f[i]) % MOD;
        }
        return (f[n - 1] + cntB) % MOD;
    }
}

