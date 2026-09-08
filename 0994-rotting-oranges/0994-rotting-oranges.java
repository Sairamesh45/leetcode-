class Solution {
    public int orangesRotting(int[][] grid) {
        int dirs[][] ={
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }
        int minutes = 0;

        while(!q.isEmpty() && fresh > 0)
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int dir[]: dirs)
                {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1)
                    {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        
        if(fresh > 0) return -1;
        return minutes;
    }
}