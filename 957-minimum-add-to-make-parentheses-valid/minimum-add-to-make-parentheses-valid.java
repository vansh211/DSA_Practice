class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans=0;
        for (char c :s.toCharArray()) {
          if(c=='('){
            st.push(c);
          }
        else{
            if(st.isEmpty()){
            ans++;
            }
            else{
                st.pop();
            }
        }
    }
        return ans+st.size();
}
}