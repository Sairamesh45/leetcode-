class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int a[][] = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[i].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.offer(new int[]{i,j});
                }
                else if(mat[i][j] == 1)
                {
                    a[i][j] = -1;
                }
            }
        }

        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length)
                {
                    if(a[nr][nc] == -1)
                    {
                        a[nr][nc] = a[r][c] + 1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return a;
    }
}