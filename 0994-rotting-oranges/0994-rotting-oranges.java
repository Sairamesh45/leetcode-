class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        int dirs[][] = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int minutes = 0;

        while(!q.isEmpty() && fresh > 0)
        {
            int size = q.size();

            for(int i = 0; i < size; i++)
            {
                int []arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                for(int dir[] : dirs)
                {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1)
                    {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }

        if(fresh > 0) return -1;

        return minutes;
    }
}