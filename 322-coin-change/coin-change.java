class Solution {
    // public int solve(int[] coins, int amount) {
    //     if(amount == 0) {
    //         return 0;
    //     }

    //     int minCoins = 2000000;

    //     for(int i = 0; i < coins.length; i++) {
    //         int coin = coins[i];
    //         if(coin <= amount) {
    //             int coinGet = solve(coins, amount - coin);

    //             int coinUsed = 1 + coinGet;
    //             minCoins = Math.min(minCoins, coinUsed);
    //         }
    //     }
    //     return minCoins;
    // }

    int[] dp;
    public int solveWithMemo(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(dp[amount] != Integer.MAX_VALUE) return dp[amount];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                int coinUsed = solveWithMemo(coins, amount - coins[i]);
                if(coinUsed != Integer.MAX_VALUE) {
                    dp[amount] = Math.min(ans, coinUsed + 1);
                }
            }
        }
        return dp[amount];
    }

    public int solveWithTab(int[] coins, int amount) {
        if(amount == 0) return 0;
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            int ans = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    int coinUsed = dp[i - coins[j]];
                    if(coinUsed != Integer.MAX_VALUE) {
                        ans = Math.min(ans, coinUsed + 1);
                    }
                }
            }
            dp[i] = ans;
        }
        return dp[amount];
    }


    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // int ans = solveWithMemo(coins, amount);
        int ans = solveWithTab(coins, amount);
        if(ans == Integer.MAX_VALUE) return -1;
        
        return ans;
    }
}