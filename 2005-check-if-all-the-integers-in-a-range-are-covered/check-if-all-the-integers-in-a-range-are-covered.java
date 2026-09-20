class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {

        for (int i = left; i <= right; i++) {
            boolean isCovered = false;

            for (int[] arr : ranges) {
                if (arr[0] <= i && arr[1] >= i) {
                    isCovered = true;
                    break;
                }
            }

            if (!isCovered) return false;
        }

        return true;
    }
}