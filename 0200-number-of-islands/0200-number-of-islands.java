class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == '1')
                {
                    grid[i][j] = '0';
                    count++;
                    Queue<int[]> q = new LinkedList<>();

                    q.offer(new int[]{i, j});

                    while(!q.isEmpty())
                    {
                        int curr[] = q.poll();

                        int r = curr[0];
                        int c = curr[1];

                        for(int dir[]: dirs)
                        {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1')
                            {
                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}