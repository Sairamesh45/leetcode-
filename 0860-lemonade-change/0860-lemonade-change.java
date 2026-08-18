class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;

        for(int i : bills)
        {
            if(i == 5)
            {
                five++;
            }

            else if(i == 10)
            {
                five--;
                ten++;

                if(five < 0) return false;
            }

            else
            {
                twenty++;

                if(ten == 0)
                {
                    five -= 3;
                    
                    if(five < 0) return false;
                }
                else{
                    ten -= 1;
                    five -= 1;

                    if(ten < 0 || five < 0) return false;
                }
            }
        }
        return true;
    }
}