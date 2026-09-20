class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for(int[] b : bookings) {
            for(int j = b[0] - 1; j <= b[1] - 1; j++){
                ans[j] += b[2];
            }

            System.out.println(ans[b[0] - 1] + " " + ans[b[1] - 1]);
        }

        return ans;
    }
}