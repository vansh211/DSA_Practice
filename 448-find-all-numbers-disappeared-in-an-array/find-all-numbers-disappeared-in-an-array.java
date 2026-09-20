class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean freq []= new boolean[nums.length+1];
        for(int i =0;i<nums.length;i++){
            freq[nums[i]]=true;
        }
        for(int i =1;i<=nums.length;i++){
            if(freq[i]==false){
                list.add(i);
            }
        }
        return list;
    }
}