class Solution {
    public void nge(int nums[], int nge[])
    {
        Stack<Integer> st = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();

            nge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int nge[] = new int[temperatures.length];
        
        nge(temperatures,nge);
        int arr[] = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++)
        {
            arr[i] = nge[i] - i;
            if(arr[i] < 0) arr[i] = 0;
        }

        return arr;
    }
}