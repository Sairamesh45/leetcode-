class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum1 = 0;
        int max = 0;
        for(int x: weights)
        {
            sum1 += x;
            max = Math.max(max,x);
        }

        int low = max, high = sum1;

        while(low < high)
        {
            int mid = (low + high) / 2;

            if(Sum(mid,weights,days))
                high = mid;
            else low = mid + 1;
        }
        return high;
    }
    boolean Sum(int mid,int weights[], int days)
    {
        int sum = 0; 
        int count = 1;
        for(int i : weights)
        {
            sum += i;
            if(sum > mid){
                sum = i;
                count++;
            }
        }
        if(count <= days) return true;
        return false;
    }
}