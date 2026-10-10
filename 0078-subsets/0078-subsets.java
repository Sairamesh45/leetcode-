class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        fn(0, nums, list, arr);

        return list;
    }

    public void fn(int i, int nums[], List<List<Integer>> list, List<Integer> arr){
        if(i == nums.length){
            list.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[i]);
        fn(i + 1, nums, list, arr);

        arr.remove(arr.size() - 1);
        fn(i + 1, nums, list, arr);
    }
}