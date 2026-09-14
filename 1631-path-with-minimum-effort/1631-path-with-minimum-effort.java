class Pair{
    int r;
    int c;
    int effort;

    Pair(int r, int c, int effort)
    {
        this.r = r;
        this.c = c;
        this.effort = effort;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.effort - b.effort));

        int dist[][] = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        pq.offer(new Pair(0, 0, 0));

        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();

            int r = curr.r;
            int c = curr.c;

            int effort = curr.effort;

            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length)
                {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort = Math.max(diff, effort);

                    if(newEffort < dist[nr][nc])
                    {
                        dist[nr][nc] = newEffort;

                        pq.offer(new Pair(nr, nc, newEffort));
                    }
                }
            }
        }

        return dist[heights.length - 1][heights[0].length - 1];
    }
}