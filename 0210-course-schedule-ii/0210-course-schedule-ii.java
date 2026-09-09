class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
        {
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        for(int curr[] : prerequisites)
        {
            int course = curr[0];
            int pre_req = curr[1];
            graph.get(pre_req).add(course);

            indegree[course]++;
        }

        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0) q.offer(i);
        }

        int arr[] = new int[numCourses];
        int index = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            arr[index++] = curr;

            for(int nei : graph.get(curr))
            {
                indegree[nei]--;

                if(indegree[nei] == 0)
                {
                    q.offer(nei);
                }
            }
        }

        if(index != numCourses)
        {
            return new int[0];
        }

        return arr;
    }
}