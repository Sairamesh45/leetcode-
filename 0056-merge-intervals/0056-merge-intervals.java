class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<int[]> arr = new ArrayList<>();
        int i = 0;
        while(i+1 < intervals.length && intervals[i][1] < intervals[i+1][0])
        {
            arr.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        while(i < intervals.length)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            i++;

            while(i < intervals.length && end >= intervals[i][0])
            {
                end = Math.max(end, intervals[i][1]);
                i++;
            }

            arr.add(new int[]{start,end});
        }

        int ans[][] = new int[arr.size()][2];

        for(int j = 0; j < ans.length; j++)
        {
            ans[j] = arr.get(j);
        }

        return ans;
    }
}