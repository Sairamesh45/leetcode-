class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int original = image[sr][sc];

        if(original == color) return image;

        q.add(new int[]{sr,sc});
        image[sr][sc] = color;

        int dirs[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int arr[] = q.poll();
                int r = arr[0];
                int c = arr[1];

                for(int dir[] : dirs)
                {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == original && image[nr][nc] != color)
                    {
                        image[nr][nc] = color;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return image;
    }
}