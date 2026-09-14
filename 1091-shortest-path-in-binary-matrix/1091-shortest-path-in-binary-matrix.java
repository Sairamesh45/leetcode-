class Edge{
    int dist;
    int[] loc;

    Edge(int dist, int loc[])
    {
        this.dist = dist;
        this.loc = loc;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
            {-1, -1},
            {1, 1},
            {1, -1},
            {-1, 1}
        };

        Queue<Edge> q = new LinkedList<>();

        q.offer(new Edge(0, new int[]{0, 0}));

        int dist[][] = new int[grid.length][grid[0].length];

        for(int i = 0; i < dist.length; i++)
        {
            for(int j = 0; j < dist[0].length; j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        while(!q.isEmpty())
        {
            Edge curr = q.poll();
            int d = curr.dist;

            int loc[] = curr.loc;

            int r = loc[0];
            int c = loc[1];

            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0)
                {
                    if(d + 1 < dist[nr][nc])
                    {
                        dist[nr][nc] = d + 1;
                        q.offer(new Edge(d+1, new int[]{nr, nc}));
                    }
                }
            }
        }

        if(dist[grid.length - 1][grid[0].length - 1] == Integer.MAX_VALUE) return -1;
        return dist[grid.length - 1][grid[0].length - 1] + 1;
    }
}