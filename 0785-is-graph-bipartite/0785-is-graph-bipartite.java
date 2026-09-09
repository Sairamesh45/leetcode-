class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;

        int color[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int k = 0; k < n; k++)
        {
            if(color[k] == -1){
                q.offer(k);
                color[k] = 1;
            }
            while(!q.isEmpty())
            {
                int size = q.size();
                for(int i = 0; i < size; i++)
                {
                    int curr = q.poll();
                    int col = color[curr];
                    for(int nei : graph[curr])
                    {
                        if(col == 0)
                        {
                            if(color[nei] == -1)
                            {
                                color[nei] = 1;
                                q.offer(nei);
                            }
                            else if(color[nei] == 0) return false;
                            else continue;
                        }
                        else if(col == 1)
                        {
                            if(color[nei] == -1)
                            {
                                color[nei] = 0;
                                q.offer(nei);
                            }
                            else if(color[nei] == 1) return false;
                            else continue;
                        }
                    }
                }
            }
        }
        return true;
    }
}