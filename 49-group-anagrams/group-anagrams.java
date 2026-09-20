class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String keyStr = String.valueOf(ch);

            if(!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        for(String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
}