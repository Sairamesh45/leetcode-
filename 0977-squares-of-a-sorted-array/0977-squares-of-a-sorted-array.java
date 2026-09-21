class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[] = new int[nums.length];

        int l = 0, r = nums.length - 1;
        int index = nums.length - 1;

        while(l <= r)
        {
            int left = nums[l] * nums[l];
            int right = nums[r] * nums[r];

            if(left > right){
                arr[index--] = left;
                l++;
            }
            else{
                arr[index--] = right;
                r--;
            }
        }

        return arr;
    }
}