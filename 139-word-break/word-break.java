class Solution {
    Boolean[] dp;
    public boolean solve(String s, HashSet<String> set) {
        if(s.length() == 0) {
            return true;
        }
        if(dp[s.length()] != null) return dp[s.length()];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(set.contains(sb.toString())) {
                if(solve(s.substring(i + 1), set)) {
                    return dp[s.length()] = true;
                }
            }
        }
        return dp[s.length()] = false;
    }

    // public boolean solveWithTab(String s, List<String> wordDict) {
    //     boolean dp[] = new boolean[s.length() + 1];
    //     dp[s.length()] = true;
        
    //     Set<String> dict = new HashSet<>(wordDict);

    //     for (int start = s.length() - 1; start >= 0; start--) {
    //         StringBuilder word = new StringBuilder();
    //         boolean flag = false;

    //         for (int i = start; i < s.length(); i++) {
    //             word.append(s.charAt(i));
    //             if (dict.contains(word.toString())) {
    //                 flag = flag || dp[i + 1];
    //             }
    //         }

    //         dp[start] = flag;
    //     }

    //     return dp[0];
    // }

    

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);

        return solve(s, set);
        // return solveWithTab(s, wordDict);
    }
}