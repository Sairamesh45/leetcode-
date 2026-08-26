class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0; 
        int max = Integer.MIN_VALUE;
        for(int i : weights)
        {
            sum += i;
            max = Math.max(i, max);
        }

        int low = max, high = sum;
        int minCap = Integer.MAX_VALUE;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            int day = Sum(weights, mid);

            if(day <= days){
                minCap = Math.min(minCap,mid);
                high = mid - 1;
            }

            else low = mid + 1;
        }

        return minCap;
    }

    public int Sum(int weights[], int k)
    {
        int day = 1;
        int sum = 0;

        for(int i = 0; i < weights.length; i++)
        {
            sum += weights[i];

            if(sum > k)
            {
                sum = weights[i];
                day++;
            }
        }

        return day;
    }
}