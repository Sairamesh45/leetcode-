class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++)
        {
            min = Math.min(piles[i], min);
            max = Math.max(piles[i], max);
        }

        int low = 0, high = max;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            int sum = Sum(piles,mid);   

            if(sum <= h)
            {
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return low;
    }

    public int Sum(int piles[], int k)
    {
        int sum = 0;

        for(int i = 0; i < piles.length; i++)
        {
            sum += Math.ceil(((double) piles[i] / k));
        }

        return sum;
    }
}