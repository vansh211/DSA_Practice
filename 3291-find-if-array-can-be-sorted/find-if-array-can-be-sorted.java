class Solution {
    public boolean canSortArray(int[] nums) {
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        for(int j=0;j<nums.length;j++)
        {
            boolean swapped=false;
            for(int i=0;i<nums.length-1-j;i++)
            {
                if(nums[i]>nums[i+1] && (Integer.bitCount(nums[i])==Integer.bitCount(nums[i+1])))
                {
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped)
            {
                break;
            }
        }
        return Arrays.equals(nums,sorted);
    }
}