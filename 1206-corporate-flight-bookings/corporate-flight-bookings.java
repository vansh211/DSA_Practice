class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n+1];

        for(int[] b : bookings) {
            flights[b[0]-1] += b[2];
            flights[b[1]] -= b[2];
        }

        int[] ans = new int[n];
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += flights[i];
            ans[i] = sum;
        }

        return ans;
    }
}