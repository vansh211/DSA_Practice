class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> set=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int count = set.getOrDefault(nums[i], 0);
            set.put(nums[i],count+1);
        }
        for(int key:set.keySet()){
            if(set.get(key)>nums.length/2){
                return key;
            }
        }
        return -1;
    }
}