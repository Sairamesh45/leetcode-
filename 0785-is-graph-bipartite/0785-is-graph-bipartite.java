class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int color[] = new int[n];
        for(int i = 0; i < color.length; i++)
        {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            int current = i;
            
            if(color[current] == -1)
            {
                color[current] = 0;
                q.offer(current);
            }

            while(!q.isEmpty())
            {
                int curr = q.poll();

                for(int nei: graph[curr])
                {
                    if(color[curr] == 0)
                    {
                        if(color[nei] == -1)
                        {
                            color[nei] = 1;
                            q.offer(nei);
                        }
                        else if(color[nei] == 0) return false;
                    }
                    else if(color[curr] == 1)
                    {
                        if(color[nei] == -1)
                        {
                            color[nei] = 0;
                            q.offer(nei);
                        }
                        else if(color[nei] == 1) return false;
                    }
                }
            }
        }

        return true;
    }
}