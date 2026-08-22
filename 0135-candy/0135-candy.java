class Solution {
    public int candy(int[] ratings) {
        int arr1[] = new int[ratings.length];
        int arr2[] = new int[ratings.length];

        int sum = 1;
        arr1[0] = 1;
        for(int i = 1; i < ratings.length; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                sum++;
                arr1[i] = sum;
            }
            else if(ratings[i] <= ratings[i-1])
            {
                sum = 1;
                arr1[i] = sum;
            }
        }

        sum = 1;
        arr2[ratings.length - 1] = 1;
        for(int i = ratings.length - 2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                sum++;
                arr2[i] = sum;
            }
            else if(ratings[i] <= ratings[i+1])
            {
                sum = 1;
                arr2[i] = sum;
            }
        }
        sum = 0;
        for(int i = 0; i < ratings.length; i++)
        {
            sum += Math.max(arr1[i],arr2[i]);
            System.out.println(Math.max(arr1[i],arr2[i]));
        }

        return sum;
    }
}