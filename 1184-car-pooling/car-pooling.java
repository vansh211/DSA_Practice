class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int lastDestination = 0;
        for(int[] trip : trips) lastDestination = Math.max(lastDestination, trip[2]);
        int[] diffArray = new int[lastDestination+1];
        for(int[] trip : trips){
            int value = trip[0];
            int start = trip[1];
            int end = trip[2];
            diffArray[start] += value;
            diffArray[end] -= value;
        }
        int temp = diffArray[0];
        if(temp > capacity) return false;
        for(int i=1;i<lastDestination;i++){
            temp += diffArray[i];
            if(temp > capacity) return false;
        }
    return true;
    }
}
