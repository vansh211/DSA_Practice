class Solution {
    Boolean[][] dp;

    boolean isPal(String s, int l, int r) {

        if (l >= r)
            return true;

        if (dp[l][r] != null)
            return dp[l][r];

        if (s.charAt(l) != s.charAt(r))
            return dp[l][r] = false;
 
        return dp[l][r] = isPal(s, l + 1, r - 1);
    }

    public int countSubstrings(String s) {

        int n = s.length();
        dp = new Boolean[n][n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isPal(s, i, j))
                    ans++;
            }
        }

        return ans;
    }
}