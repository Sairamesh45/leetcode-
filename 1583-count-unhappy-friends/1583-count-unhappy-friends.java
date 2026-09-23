class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int partner[] = new int[n];
        for(int i = 0; i < pairs.length; i++){
            int a = pairs[i][0];
            int b = pairs[i][1];

            partner[a] = b;
            partner[b] = a;
        }

        int rank[][] = new int[preferences.length][preferences.length];

        for(int i = 0; i < preferences.length; i++){
            for(int j = 0; j < preferences[i].length; j++){
                rank[i][preferences[i][j]] = j;
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(rank[i][j] < rank[i][partner[i]]){
                    if(rank[j][i] < rank[j][partner[j]]){
                        count++;
                        break;
                    }
                }
            }
        }

        return count;

    }
}