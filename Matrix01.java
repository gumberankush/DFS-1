// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity: O(m*n) where m is the number of rows and n is the number of columns
// Approach: BFS
// 1. We will start from the cell with value 0 and add it to the queue.
// 2. We will iterate over the 4 directions and check if the new cell is within the bounds and has value -1.
// 3. If yes, we will add the cell to the queue and change the value of the cell to the distance from the cell with value 0.


import java.util.LinkedList;
import java.util.Queue;

class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                }else if(mat[i][j] == 1){
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] elem = queue.poll();

                for(int[] dir: dirs){
                    int nr = elem[0] + dir[0];
                    int nc = elem[1] + dir[1];

                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1){
                        queue.add(new int[]{nr, nc});
                        mat[nr][nc] = dist + 1;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
