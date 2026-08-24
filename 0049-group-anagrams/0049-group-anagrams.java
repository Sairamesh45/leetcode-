class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++)
        {
            int freq[] = new int[26];
            for(int j = 0; j < strs[i].length(); j++)
            {
                freq[strs[i].charAt(j) - 'a']++;
            }

            String str = Arrays.toString(freq);

            if(map.containsKey(str))
            {
                map.get(str).add(strs[i]);
            }
            else{
                List<String> arr = new ArrayList<>();
                map.put(str,arr);
                map.get(str).add(strs[i]);
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(String str : map.keySet())
        {
            list.add(map.get(str));
        }

        return list;
    }
}