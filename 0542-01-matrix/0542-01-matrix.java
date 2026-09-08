class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int n = mat.length;
        int m = mat[0].length;

        int arr[][] = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(mat[i][j] == 0)
                {
                    arr[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
                else{
                    arr[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >=0 && nc < m && arr[nr][nc] == -1)
                {
                    arr[nr][nc] = arr[r][c] + 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return arr;
    }
}