class Solution {
    public int alternateDigitSum(int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        
        while(n>0){
            list.add(0, n%10);
            n /= 10;
        }
        
        for(int i=0;i<list.size();i++){
            if(i%2 == 0){
                sum += list.get(i);
            }
            else{
                sum -= list.get(i);
            }
        }
        return sum;
    }
}