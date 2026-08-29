class Solution {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++)
        {
            if(board[i][0] == 'O')
            {
                board[i][0] = 'S';
                q.offer(new int[]{i,0});
            }

            if(board[i][n-1] == 'O')
            {
                board[i][n-1] = 'S';
                q.offer(new int[]{i,n-1});
            }
        }

        for(int j = 0; j < n; j++)
        {
            if(board[0][j] == 'O')
            {
                board[0][j] = 'S';
                q.offer(new int[]{0, j});
            }

            if(board[m-1][j] == 'O')
            {
                board[m-1][j] = 'S';
                q.offer(new int[]{m-1, j});
            }
        }

        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };


        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[] : dirs)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O')
                {
                    board[nr][nc] = 'S';
                    q.offer(new int[]{nr,nc});
                }

            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
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