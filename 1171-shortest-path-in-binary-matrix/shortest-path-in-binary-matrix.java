class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if ((grid[0][0] == 1) || (grid[n - 1][n - 1] == 1))
            return -1;

        int path = 1;
        boolean vis[][] = new boolean[n][n];
        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[] { 0, 0 });
        vis[0][0]=true;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int[] arr = qu.poll();
                int r = arr[0];
                int c = arr[1];
                if (r == n - 1 && c == n - 1)
                    return path;
                
                if (r - 1 >= 0 && grid[r - 1][c] != 1 && vis[r - 1][c] != true) {
                    vis[r-1][c] = true;
                    qu.offer(new int[] { r - 1, c });
                }

                if (c - 1 >= 0 && grid[r][c - 1] != 1 && vis[r][c - 1] != true) {
                    
                    vis[r][c-1] = true;
                    qu.offer(new int[] { r, c - 1 });
                    
                }

                if (r - 1 >= 0 && c - 1 >= 0 && grid[r - 1][c - 1] != 1 && vis[r - 1][c - 1] != true) {
                    vis[r-1][c-1] = true;
                    qu.offer(new int[] { r - 1, c - 1 });

                }

                if (r - 1 >= 0 && c + 1 < n && grid[r - 1][c + 1] != 1 && vis[r - 1][c + 1] != true) {
                    vis[r-1][c+1] = true;
                    qu.offer(new int[] { r - 1, c + 1 });

                }

                if (r + 1 < n && grid[r + 1][c] != 1 && vis[r + 1][c] != true) {
                    vis[r+1][c] = true;
                    qu.offer(new int[] { r + 1, c });

                }

                if (r + 1 < n && c - 1 >= 0 && grid[r + 1][c - 1] != 1 && vis[r + 1][c - 1] != true) {
                    vis[r+1][c-1] = true;
                    qu.offer(new int[] { r + 1, c - 1 });

                }

                if (r + 1 < n && c + 1 < n && grid[r + 1][c + 1] != 1 && vis[r + 1][c + 1] != true) {
                    vis[r+1][c+1] = true;
                    qu.offer(new int[] { r + 1, c + 1 });

                }

                if (c + 1 < n && grid[r][c + 1] != 1 && vis[r][c + 1] != true) {
                    vis[r][c+1] = true;
                    qu.offer(new int[] { r, c + 1 });

                }
            }
            path++;
        }
        return qu.isEmpty()!=false?-1:path;
    }
}