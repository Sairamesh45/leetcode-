class Solution {
    public boolean lemonadeChange(int[] bills) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i : bills){
            map.put(i,map.getOrDefault(i,0)+1);

            if(i == 10)
            {
                if(!map.containsKey(5)) return false;
                else{
                    map.put(5, map.get(5) - 1);
                    if(map.get(5) == 0) map.remove(5);
                }
            }

            else if(i == 20)
            {
                if(!map.containsKey(5)) return false;

                else{
                    if(!map.containsKey(10))
                    {
                        if(map.get(5) < 3) return false;
                        else{
                            map.put(5, map.get(5) - 3);
                            if(map.get(5) == 0) map.remove(5);
                        }
                    }
                    else{
                        map.put(10, map.get(10) - 1);
                        if(map.get(10) == 0) map.remove(10);

                        map.put(5, map.get(5) - 1);
                        if(map.get(5) == 0) map.remove(5);
                    }
                }
            }
        }
        return true;
    }
}