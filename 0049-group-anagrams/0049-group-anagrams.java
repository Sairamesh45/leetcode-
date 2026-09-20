class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++)
        {
            int freq[] = new int[26];
            for(int j = 0; j < strs[i].length(); j++)
            {
                char ch = strs[i].charAt(j);
                freq[ch - 'a']++;
            }
            
            String str = Arrays.toString(freq);

            if(!map.containsKey(str))
                map.put(str, new ArrayList<>());
            
            map.get(str).add(strs[i]);
        }

        List<List<String>> arr = new ArrayList<>();

        for(String i : map.keySet())
        {
            arr.add(map.get(i));
        }

        return arr;
    }
}