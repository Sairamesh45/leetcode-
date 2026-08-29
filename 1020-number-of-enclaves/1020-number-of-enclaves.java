class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++)
        {
            if(grid[i][0] == 1)
            {
                grid[i][0] = 2;
                q.offer(new int[]{i,0});
            }

            if(grid[i][n-1] == 1)
            {
                grid[i][n-1] = 2;
                q.offer(new int[]{i,n-1});
            }
        }

        for(int j = 0; j < n; j++)
        {
            if(grid[0][j] == 1)
            {
                grid[0][j] = 2;
                q.offer(new int[]{0,j});
            }

            if(grid[m-1][j] == 1)
            {
                grid[m-1][j] = 2;
                q.offer(new int[]{m-1,j});
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

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr,nc});
                }
            }
        }   

        int count = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                    count++;

                if(grid[i][j] == 2)
                    grid[i][j] = 1;
            }
        }

        return count;
    }
}