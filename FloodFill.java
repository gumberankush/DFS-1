// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity: O(m*n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approach:
// 1. We can solve this problem using both BFS and DFS.
// 2. In BFS, we will start from the given cell and change the color of the cell to the new color.
// 3. We will then iterate over the 4 directions and check if the new cell is within the bounds and has the same color as the initial color.
// 4. If yes, we will add the cell to the queue and change the color of the cell to the new color.
// 5. We will repeat the process until the queue is empty.
// 6. In DFS, we will start from the given cell and change the color of the cell to the new color.

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {

    // BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = image.length;
        int n = image[0].length;

        int initialColor = image[sr][sc];
        if (initialColor == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!queue.isEmpty()){
            int[] elem = queue.poll();

            for(int[] dir: dirs){
                int nr = dir[0] + elem[0];
                int nc = dir[1] + elem[1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == initialColor){
                    queue.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }
        return image;
    }

    // DFS
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int initialColor = image[sr][sc];
        if (initialColor == color) {
            return image;
        }
        dfs(image, sr, sc, color, initialColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int initialColor){
        // base
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != initialColor){
            return;
        }

        // logic
        image[row][col] = color;
        for(int[] dir: dirs){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            dfs(image, nr, nc, color, initialColor);
        }
    }
}
