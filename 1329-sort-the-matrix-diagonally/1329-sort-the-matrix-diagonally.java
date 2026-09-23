class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i = 0; i < mat.length; i++){
            sortDiagonal(mat, i, 0);
        }

        for(int i = 0; i < mat[0].length; i++){
            sortDiagonal(mat, 0, i);
        }

        return mat;
    }

    public void sortDiagonal(int mat[][], int r, int c){
        List<Integer> arr = new ArrayList<>();
        int row = r;
        int col = c;

        while(r < mat.length && c < mat[0].length){
            arr.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(arr);

        int index = 0;
        
        while(row < mat.length && col < mat[0].length){
            mat[row][col] = arr.get(index);
            index++;
            row++;
            col++;
        }
    }
}