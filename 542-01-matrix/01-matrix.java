class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(mat[i][j] == 0) {
                    dist[i][j] = 0;

                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty()) {

            int[] node = q.poll();

            int r = node[0];
            int c = node[1];

            for(int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 &&
                   nc >= 0 &&
                   nr < n &&
                   nc < m &&
                   dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return dist;
    }
}