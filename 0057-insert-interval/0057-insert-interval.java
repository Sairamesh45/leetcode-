class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arr = new ArrayList<>();

        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0])
        {
            arr.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= newInterval[1])
        {
            start = Math.min(intervals[i][0],start);
            end = Math.max(intervals[i][1],end);
            i++;
        }

        arr.add(new int[]{start,end});

        while(i < intervals.length && intervals[i][0] > newInterval[1])
        {
            arr.add(new int[]{intervals[i][0],intervals[i][1]});
            i++;
        }

        int arr1[][] = new int[arr.size()][2];

        for(int j = 0; j < arr1.length; j++)
        {
            arr1[j] = arr.get(j);
        }

        return arr1;
    }
}