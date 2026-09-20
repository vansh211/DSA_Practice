class Solution {
    // int[] dp;
    // public int solve(int n) {
    //     if(n == 0) return 0;
    //     if(n <= 0) return Integer.MAX_VALUE;
    //     if(dp[n] != -1) return dp[n];

    //     int ans = Integer.MAX_VALUE;
    //     for(int i = 1; i <= Math.sqrt(n); i++) {
    //         int recAns = 1 + solve(n - (i * i));
    //         ans = Math.min(recAns, ans);
    //     }
    //     return dp[n] = ans;
    // }

    public int solveWithTab(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for(int j = 1; j <= n; j++) {
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i <= Math.sqrt(n); i++) {
                int recAns = Integer.MAX_VALUE;
                if(j - (i * i) >= 0) recAns = 1 + dp[j - (i * i)];
                ans = Math.min(recAns, ans);
            }
            dp[j] = ans;
        }
        return dp[n];
    }

    public int numSquares(int n) {
        // dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        
        // return solve(n);
        return solveWithTab(n);
    }
}