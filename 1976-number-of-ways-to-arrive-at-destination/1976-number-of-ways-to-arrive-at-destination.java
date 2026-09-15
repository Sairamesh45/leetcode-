class Edge{
    int node;
    long dist;

    Edge(int node, long dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++)
        {
            int u = roads[i][0];
            int v = roads[i][1];
            long dist = roads[i][2];

            graph.get(u).add(new Edge(v, dist));
            graph.get(v).add(new Edge(u, dist));
        }

        long dist[] = new long[n];
        long ways[] = new long[n];

        Arrays.fill(ways, 0);
        Arrays.fill(dist, Long.MAX_VALUE);

        int source = 0;
        int dest = n - 1;

        dist[source] = 0;
        ways[source] = 1;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        pq.offer(new Edge(0, 0));

        while(!pq.isEmpty())
        {
            Edge p = pq.poll();
            int node = p.node;
            long d1 = p.dist;

            if(d1 > dist[node]) continue;

            for(Edge nei : graph.get(node))
            {
                int neiNode = nei.node;
                long d2 = nei.dist;

                if(d1 + d2 < dist[neiNode])
                {
                    dist[neiNode] = d1 + d2;
                    pq.offer(new Edge(neiNode, d1 + d2));
                    ways[neiNode] = ways[node];
                }

                else if(d1 + d2 == dist[neiNode]){
                    ways[neiNode] = (ways[neiNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[dest] ;
    }
}