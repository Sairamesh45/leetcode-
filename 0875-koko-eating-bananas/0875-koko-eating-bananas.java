class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles)
        {
            max = Math.max(i, max);
        }

        Arrays.sort(piles);

        int l = 1, r = max;

        while(l <= r)
        {
            int mid = (l + r) / 2;

            if(helper(piles, mid, h))
            {
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return l;
    }

    public boolean helper(int piles[], int mid, int h)
    {
        int sum = 0;
        for(int i = 0; i < piles.length; i++)
        {
            sum += Math.ceil((double) piles[i] / mid);
        }

        if(sum > h) return false;
        return true;
    }
}