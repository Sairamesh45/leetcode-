class Solution {
    public int[] plusOne(int[] digits) {
        int arr[] = new int[digits.length + 1];
        int carry = 0;
        if(digits[digits.length - 1] >= 9){
            arr[digits.length] = 0;
            carry += digits[digits.length - 1] - 9 + 1;
        }
        else{
            arr[digits.length] = digits[digits.length - 1] + 1;
        }

        for(int i = digits.length - 2; i >= 0; i--){
            int curr = digits[i] + carry;
            carry = 0;

            if(curr > 9){
                arr[i+1] = 0;
                carry += curr - 9;
            }
            else{
                arr[i+1] = curr;
            }
        }
        if(carry != 0){
            arr[0] = carry;
        }
        else{
            int curr[] = new int[digits.length];
            for(int i = 1; i <= digits.length; i++){
                curr[i-1] = arr[i];
            }
            return curr;
        }
        

        return arr;
    }
}