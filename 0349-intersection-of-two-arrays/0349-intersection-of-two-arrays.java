class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        HashSet<Integer> arr = new HashSet<>();

        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;

            else{
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] a = new int[arr.size()];

        i = 0;
        for(int k : arr)
        {
            a[i++] = k;
        }

        return a;
    }
}