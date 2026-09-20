class Pair{
    int r, c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int count = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                Queue<Pair> st = new LinkedList<>();
                if(grid[i][j] == '1'){
                    st.offer(new Pair(i, j));
                    count++;

                    while(!st.isEmpty())
                    {
                        Pair p = st.poll();

                        int r = p.r;
                        int c = p.c;

                        for(int dir[] : dirs)
                        {
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                st.offer(new Pair(nr, nc));
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}