class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> arr = new ArrayList<>();
        fn(map, 0, "", digits, arr);
        return arr;
    }

    public void fn(HashMap<Integer,String> map, int i, String str, String digits, List<String> arr){
        if(i == digits.length()){
            arr.add(str);
            return;
        }

        String s = map.get(digits.charAt(i) - '0');

        for(int k = 0; k < s.length(); k++){
            char ch = s.charAt(k);

            fn(map, i+1, str + ch, digits, arr);
        }
    }
}