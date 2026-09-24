class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long ans = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            
            long low = 0;
            long high = 2_000_000_000L;            
            while(low <= high){
                long mid = (low + high) / 2;

                if(canProduce(n,composition, mid, i, budget, stock, cost)){
                    ans = Math.max(ans, mid);
                    low = mid + 1;
                }
                else high = mid - 1;
            }
        }
        return (int)ans;
    }

    public boolean canProduce(int n, List<List<Integer>> composition, long amount, int i, int budget, List<Integer> stock, List<Integer> cost){
        long total = 0;

        for(int j = 0; j < n; j++){
            long req = (long)composition.get(i).get(j) * amount;

            if(req > stock.get(j)){
                long need = (long) req - stock.get(j);

                total += need * cost.get(j);

                if(total > budget) return false;
            }
        }
        return true;
    }
}