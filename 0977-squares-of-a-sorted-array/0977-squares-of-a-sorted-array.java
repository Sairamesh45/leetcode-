class Solution {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);

        for(int i : nums){
            int sq = i * i;
            pq.offer(sq);
        }

        int index = 0;

        while(!pq.isEmpty()){
            nums[index++] = pq.poll();
        }

        return nums;
    }
}