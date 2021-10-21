package programmers.RotateMatrixEndLines;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int cnt = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = cnt++;
            }
        }

        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int r1 = query[0] - 1, c1 = query[1] - 1, r2 = query[2] - 1, c2 = query[3] - 1;
            int min = matrix[r1][c2];

            // 윗줄 == r1 (오 -> 왼)
            for(int c = c2; c > c1; c--){
                int tmp = matrix[r1][c - 1];
                matrix[r1][c - 1] = matrix[r1][c];
                matrix[r1][c] = tmp;
                if(min > tmp) min = tmp;
            }

            // 왼쪽줄 == c1 (위 -> 아래)
            for(int r = r1;  r < r2; r++){
                int tmp = matrix[r + 1][c1];
                matrix[r + 1][c1] = matrix[r][c1];
                matrix[r][c1] = tmp;
                if(min > tmp) min = tmp;
            }

            // 아랫줄 == r2 (왼 -> 오)
            for(int c = c1; c < c2; c++){
                int tmp = matrix[r2][c + 1];
                matrix[r2][c + 1] = matrix[r2][c];
                matrix[r2][c] = tmp;
                if(min > tmp) min = tmp;
            }

            // 오른쪽줄 == c2 (아래 -> 위)
            for(int r = r2;  r > r1 + 1; r--){
                int tmp = matrix[r - 1][c2];
                matrix[r - 1][c2] = matrix[r][c2];
                matrix[r][c2] = tmp;
                if(min > tmp) min = tmp;
            }
            answer[i] = min;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] queries = {{2,2,5,4}, {3,3,6,6},{5,1,6,3}};
        new Solution().solution(6, 6, queries);
    }
}
