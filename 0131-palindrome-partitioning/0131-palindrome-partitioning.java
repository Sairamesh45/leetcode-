class Solution {
    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> arr = new ArrayList<>();

        List<String> curr = new ArrayList<>();

        fn(s, arr, curr, 0, 0);

        return arr;
    }

    public void fn(String s, List<List<String>> arr, List<String> curr, int i, int j){
        if(i == s.length()){
            arr.add(new ArrayList<>(curr));
            return;
        }

        if(j == s.length()) return;

        if(isPalindrome(s.substring(i, j + 1))){
            curr.add(s.substring(i, j + 1));
            fn(s, arr, curr, j + 1, j + 1);

            curr.remove(curr.size() - 1);
        }
        
        fn(s, arr, curr, i, j + 1);

    }
}