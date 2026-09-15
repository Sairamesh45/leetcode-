class Edge
{
    int u, dist;

    Edge(int u, int dist){
        this.u = u;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++)
        {
            int u = times[i][0];
            int v = times[i][1];
            int dist = times[i][2];

            graph.get(u - 1).add(new Edge(v - 1, dist));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        pq.offer(new Edge(k - 1, 0));

        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k - 1] = 0;
        while(!pq.isEmpty())
        {
            Edge p = pq.poll();

            int u = p.u;
            int d1 = p.dist;

            if(d1 > dist[u]) continue;

            for(Edge nei : graph.get(u))
            {
                int v = nei.u;
                int d2 = nei.dist;

                if(d1 + d2 < dist[v])
                {
                    dist[v] = d1 + d2;
                    pq.offer(new Edge(v, d1 + d2));
                }
            }
        }   

        int max = Integer.MIN_VALUE;
        for(int i : dist)
        {
            max = Math.max(max, i);
        }
        
        if(max == Integer.MIN_VALUE || max == Integer.MAX_VALUE) return -1;

        return max;
    }
}