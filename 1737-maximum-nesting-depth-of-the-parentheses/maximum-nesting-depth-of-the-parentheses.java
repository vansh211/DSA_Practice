class Solution {
    public int maxDepth(String s) {
        int open = 0, ans = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '('){
                open++;
                ans = Math.max(ans, open);
            }
            else if (ch == ')') open--;
        }

        return ans;
    }
}