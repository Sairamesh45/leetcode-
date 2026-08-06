class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0; 
        for(int n : piles)
        {
            max = Math.max(n,max);
        }

        int low = 0, high = max;

        while(low < high)
        {
            int mid = (low + high) / 2;

            int sum = Sum(mid,piles);

            if(sum > h) low = mid+1;
            else high = mid;
        }
        return high;
    }
    int Sum(int mid, int piles[])
    {
        int sum = 0; 
        for(int i = 0; i < piles.length; i++)
        {
            sum += Math.ceil((double) piles[i]/mid);
        }

        return sum;
    }
}