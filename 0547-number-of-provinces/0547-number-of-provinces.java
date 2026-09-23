class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();

        int n = isConnected.length; 
        int m = isConnected[0].length;

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean visited[] = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, graph);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, boolean visited[], List<List<Integer>> graph){
        if(!visited[node]){
            visited[node] = true;
            for(int nei : graph.get(node)){
                if(!visited[nei]) dfs(nei, visited, graph);
            }
        }
    }
}