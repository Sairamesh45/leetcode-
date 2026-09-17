class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            dist[u][v] = d;
            dist[v][u] = d;
        }

        for(int via = 0; via < n; via++)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(dist[i][via] != Integer.MAX_VALUE && dist[via][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int minCount = Integer.MAX_VALUE;
        int ans = 0;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] != Integer.MAX_VALUE && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= minCount)
            {
                minCount = count;
                ans = i;
            }
        }

        return ans;
    }
}