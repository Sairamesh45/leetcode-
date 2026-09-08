class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int indegree[] = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int arr[] : prerequisites)
        {
            int course = arr[0];
            int pre_req = arr[1];

            indegree[course]++;
            graph.get(pre_req).add(course);
            graph.get(course).add(pre_req);
        }
        
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int completed = 0;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            completed++;

            for(int next: graph.get(curr))
            {
                indegree[next]--;

                if(indegree[next] == 0) q.offer(next);
            }
        }
        return completed == numCourses;
    }
}