class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        fn(0, arr, curr, candidates, target, 0);
        
        return arr;
    }

    public void fn(int i, List<List<Integer>> arr, List<Integer> curr, int candidates[], int target, int sum){
        if(sum == target){
            arr.add(new ArrayList<>(curr));
            return;
        }

        if(i == candidates.length){
            return;
        }

        if(sum > target){
            return;
        }

        // while(i != 0 && candidates[i] == candidates[i - 1]) i++;

        curr.add(candidates[i]);
        fn(i, arr, curr, candidates, target, sum + candidates[i]);

        curr.remove(curr.size() - 1);
        fn(i + 1, arr, curr, candidates, target, sum);
    }

}