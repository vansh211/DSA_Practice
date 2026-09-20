class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int n = flowers.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {

            int p = people[i];

            // flowers that have started by time p
            int started = upperBound(start, p);

            // flowers that ended before time p
            int ended = lowerBound(end, p);

            ans[i] = started - ended;
        }

        return ans;
    }

    // first index where arr[index] > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    // first index where arr[index] >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}