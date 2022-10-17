package RangeQueries;

import java.util.ArrayList;

public class rangeProductQueries {
    private static int mod = 1000000007;

    public int[] productQueries(int n, int[][] queries) {

        int[] ans = new int[queries.length];

        String binaryString = Integer.toBinaryString((n));
        ArrayList<Integer> pow = new ArrayList<>();
        for (int i = 31, p = 0; i >= 0; i--, p++) {
            if (binaryString.charAt(i) == '1') {
                pow.add((getPow(p)) % mod);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int p = queries[i][1];
            long mul = 1;
            for (int start = a; start <= p; start++) {
                mul = (mul * (pow.get(start))) % mod;
            }
            ans[i] = (int) mul % mod;
        }
        return ans;
    }

    private static int getPow(int a) {
        int mul = 2;
        int ans = 1;
        if (a == 0)
            return 1;
        while (a > 0) {
            if (a % 2 == 0) {
                mul = (mul * 2) % mod;
                a /= 2;
            } else {
                ans = (ans * mul) % mod;
                a -= 1;
            }
        }
        return ans % mod;
    }
}
