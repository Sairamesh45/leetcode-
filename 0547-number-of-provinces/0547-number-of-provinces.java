class Solution {
    int count = 0;
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();

        int n = isConnected.length;
        for(int i = 1; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                dfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(List<List<Integer>> graph, boolean []visited, int node)
    {
        visited[node] = true;

        for(int nei : graph.get(node))
        {
            if(!visited[nei]){
                dfs(graph, visited, nei);
            }
        }
    }
}