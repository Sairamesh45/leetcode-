class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int i : nums){
            pq.offer(i);
        }

        int i = 1;
        while(i < k && !pq.isEmpty()){
            pq.poll();
            i++;
        }

        return pq.poll();
    }
}