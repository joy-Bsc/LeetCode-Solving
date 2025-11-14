package problemSolving;

import java.util.Arrays;

public class LeetCode2536Simple {
    public static int[][] rangeAddQueries(int n, int[][] queries){
        int[][] answer = new int[n][n];
        for(int[] query : queries){
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            answer[row1][col1] += 1;
            if(row2+1 < n) answer[row2 + 1][col1] -= 1;
            if(col2+1 < n) answer[row1][col2+1] -= 1;
            if((row2+1 < n) && (col2+1 < n)) answer[row2+1][col2+1]+= 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                answer[i][j] += answer[i][j-1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                answer[j][i] += answer[j-1][i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {
                {1,1,2,2},
                {0,0,1,1},

        };

        int[][] result = rangeAddQueries(n, queries);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
