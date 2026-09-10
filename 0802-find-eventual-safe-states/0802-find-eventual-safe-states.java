class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        int indegree[] = new int[n];

        List<List<Integer>> graph1 = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            graph1.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++)
        {
            indegree[i] = 0;
        }

        for(int i = 0; i < n; i++)
        {
            int curr[] = graph[i];
            if(curr.length > 0)
                indegree[i] += curr.length;
            for(int j : curr)
            {
                graph1.get(j).add(i);
            }
        }

        List<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            arr.add(curr);

            for(int nei : graph1.get(curr))
            {
                indegree[nei]--;

                if(indegree[nei] == 0)
                {
                    q.offer(nei);
                }
            }
        }

        Collections.sort(arr);
        return arr;
    }
}