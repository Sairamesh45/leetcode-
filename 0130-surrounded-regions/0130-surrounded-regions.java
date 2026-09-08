class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for(int i = 0; i < n; i++)
        {
            if(board[i][0] == 'O'){
            board[i][0] = 'S';
            q.offer(new int[]{i,0});
            }

            if(board[i][m-1] == 'O'){
            board[i][m-1] = 'S';
            q.offer(new int[]{i,m-1});
            }
        }

        for(int j = 0; j < m; j++)
        {
            if(board[0][j] == 'O'){
            board[0][j] = 'S';
            q.offer(new int[]{0,j});
            }

            if(board[n-1][j] == 'O'){
            board[n-1][j] = 'S';
            q.offer(new int[]{n-1,j});
            }
        }


        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[]: dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O')
                {
                    board[nr][nc] = 'S';
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }

                else if(board[i][j] == 'S')
                {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
}