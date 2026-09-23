class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];

        List<Integer> arr = new ArrayList<>();
        if(start <= end){
            for(int i = start; i <= end; i++){
                arr.add(i);
            }
        }
        else{
            for(int i = 1; i <= end; i++) arr.add(i);
            for(int i = start; i <= n; i++) arr.add(i);
        }
        return arr;
    }
}