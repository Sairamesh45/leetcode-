class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        boolean used[] = new boolean[nums.length];

        fn(arr, curr, nums, 0, used);

        return arr;
    }

    public void fn( List<List<Integer>> arr, List<Integer> curr, int nums[], int i, boolean[] used){
        if(i == nums.length){
            arr.add(new ArrayList<>(curr));
            return;
        }


        for(int j = 0; j < nums.length; j++){
            if(used[j]) continue;

            curr.add(nums[j]);
            used[j] = true;
            fn(arr, curr, nums, i + 1, used);

            used[j] = false;
            curr.remove(curr.size() - 1);
        }   
    }
}