class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();

        int n = isConnected.length;
        int m = isConnected[0].length;

        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < m; j++)
            {
                if(isConnected[i][j] == 1){
                graph.get(i).add(j);
                graph.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[n];

        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                dfs(visited, graph, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(boolean visited[], List<List<Integer>> graph, int node)
    {
        visited[node] = true;

        for(int nei : graph.get(node))
        {
            if(!visited[nei]) dfs(visited,graph,nei);
        }
    }
}