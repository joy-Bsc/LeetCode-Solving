package problemSolving;

public class LeetCode2257 {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls){
        int[][] result = new int[m][n];
        int unguardedCount = 0;
        for(int[] guard : guards){
            int row = guard[0];
            int col = guard[1];
            result[row][col] = 3;
        }
        for(int[] wall : walls){
            int row = wall[0];
            int col = wall[1];
            result[row][col] = 2;
        }
        for(int[] guard : guards){
            int row = guard[0];
            int col = guard[1];
            guarded(result , row-1 , col , -1 , 0 , m , n);
            guarded(result , row+1 , col ,  1 , 0 , m , n);
            guarded(result , row , col-1 ,  0 , -1 , m , n);
            guarded(result , row , col+1 ,  0 ,  1 , m , n);

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(result[i][j] == 0){
                    unguardedCount++;
                }
            }
        }
        return unguardedCount;

    }

    private static void guarded(int[][] result, int row, int col, int direction_i, int direction_j, int m, int n) {
        while (row >= 0 && row < m && col >= 0 && col < n){
            if(result[row][col] == 3 || result[row][col] == 2 ){
                break;
            }
            if(result[row][col] == 0){
                result[row][col] = 1;
            }
            row += direction_i;
            col += direction_j;
        }
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0,0}, {1,1}, {2,3}};
        int[][] walls = {{0,1}, {2,2}, {1,4}};

        int result = countUnguarded(m, n, guards, walls);
        System.out.println("Output: " + result);
    }
}
