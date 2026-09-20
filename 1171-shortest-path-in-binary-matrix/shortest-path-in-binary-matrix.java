class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // row, col, path-length
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});

        // Mark as visited
        grid[0][0] = 1;

        int[][] directions = {
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {-1, 0},
            {-1, 1},
            {0, 1},
            {1, 1}
        };

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int row = current[0];
            int col = current[1];
            int pathLength = current[2];

            if (row == n - 1 && col == n - 1) {
                return pathLength;
            }

            for (int i = 0; i < 8; i++) {

                int x = row + directions[i][0];
                int y = col + directions[i][1];

                if (x >= 0 && x < n &&
                    y >= 0 && y < n &&
                    grid[x][y] == 0) {

                    grid[x][y] = 1;

                    q.add(new int[]{
                        x,
                        y,
                        pathLength + 1
                    });
                }
            }
        }

        return -1;
    }
}