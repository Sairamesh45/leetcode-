class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int curr = 0;
        int max = 0;
        while(l < r)
        {
            curr = Math.min(height[l], height[r]) * (r-l);
            if(height[l] < height[r])
                l++;
            else r--;

            max = Math.max(curr,max);
        }

        return max;
    }
}