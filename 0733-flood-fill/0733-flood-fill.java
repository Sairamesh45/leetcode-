class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        image[sr][sc] = color;
        Queue<int[]> q = new LinkedList<>();

        int n = image.length;
        int m = image[0].length;

        q.offer(new int[]{sr,sc});
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

                if(nr >= 0 && nc >= 0 && nr < n && nc < m && image[nr][nc] == original) 
                {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}