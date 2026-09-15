class Pair
{
    int node;
    int curr;
    int dist;

    Pair(int node, int curr, int dist){
        this.node = node;
        this.curr = curr;
        this.dist = dist;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++)
        {
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];

            graph.get(u).add(new Pair(v, 0, cost));
        }

        int minCost[][] = new int[n][k + 2];
        for(int i = 0; i < minCost.length; i++)
        {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.offer(new Pair(src, 0, 0));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int u = p.node;
            int currNodes = p.curr;
            int d = p.dist;

            if (u == dst) {
                return d;
            }

            if(currNodes == k+1) continue;

            for(Pair nei : graph.get(u))
            {
                int v = nei.node;
                int dist = nei.dist;

                int newCost = d + dist;
                int newFlights = currNodes + 1;

                if(newCost < minCost[v][newFlights]) {

                    minCost[v][newFlights] = newCost;

                    pq.offer(
                        new Pair(v, newFlights, newCost)
                    );
                }
            }
        }
        return -1;
    }
}