class Solution {
    public int[] frequencySort(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>((a,b) -> b - a);

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int freqA = map.get(a), freqB = map.get(b);

            if(freqA != freqB) return freqA - freqB;
            return b - a;
        });

        for(int i : map.keySet()){
            pq.offer(i);
        }

        int index = 0;

        while(!pq.isEmpty()){
            int curr = pq.poll();
            int size = map.get(curr);

            for(int i = 0; i < size; i++)
            {
                nums[index++] = curr;
            }
        }
        
        return nums;
    }
}