class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++)
        {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.') {
                    if(row.contains(board[i][j])) {
                        return false;
                    }

                    row.add(board[i][j]);
                }

                if(board[j][i] != '.') {
                    if(col.contains(board[j][i])) {
                        return false;
                    }

                    col.add(board[j][i]);
                }
            }
        }
        for(int row = 0; row < 9; row += 3) {
    for(int col = 0; col < 9; col += 3) {

        HashSet<Character> box = new HashSet<>();

        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {

                if(board[i][j] == '.') continue;

                if(box.contains(board[i][j])) {
                    return false;
                }

                box.add(board[i][j]);
            }
        }
    }
}

        return true;
    }
}