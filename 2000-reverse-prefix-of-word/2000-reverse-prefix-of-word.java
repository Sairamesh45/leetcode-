class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char ch1 = word.charAt(i);

            if(ch1 == ch){
                str.append(word.substring(0, i + 1));
                str.reverse();
                str.append(word.substring(i + 1, word.length()));
                return str.toString();
            }
        }
        return word;
    }
}