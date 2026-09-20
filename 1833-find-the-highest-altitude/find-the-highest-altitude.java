class Solution {
    public int largestAltitude(int[] gain) {
        int summmm=0;
        int maxxxx=0;
        for(int i=0;i<gain.length;i++){
            summmm+=gain[i];
            maxxxx=Math.max(maxxxx,summmm);
        }
        return maxxxx;
    }
}