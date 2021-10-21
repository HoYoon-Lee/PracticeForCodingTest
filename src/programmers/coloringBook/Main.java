package programmers.coloringBook;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] p) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] picture = new int[m][n];
        for(int i = 0; i < m; i++){
            picture[i] = p[i].clone();
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0){
                    Queue<int[]> q = new LinkedList<>();
                    int color = picture[i][j];
                    q.offer(new int[]{i, j});
                    picture[i][j] = 0;
                    int cnt = 1;

                    while (!q.isEmpty()){
                        int[] xy = q.poll();
                        int x = xy[0], y = xy[1];
                        // 위
                        if(x - 1 >= 0 && picture[x-1][y] == color){
                            q.offer(new int[]{x -1, y});
                            picture[x - 1][y] = 0;
                            cnt++;
                        }
                        // 아래
                        if(x + 1 < picture.length && picture[x + 1][y] == color){
                            q.offer(new int[]{x + 1, y});
                            picture[x + 1][y] = 0;
                            cnt++;
                        }
                        // 왼쪽
                        if(y - 1 >= 0 && picture[x][y - 1] == color){
                            q.offer(new int[]{x, y - 1});
                            picture[x][y - 1] = 0;
                            cnt++;
                        }
                        // 오른쪽
                        if(y + 1 < picture[x].length && picture[x][y + 1] == color){
                            q.offer(new int[]{x, y + 1});
                            picture[x][y + 1] = 0;
                            cnt++;
                        }
                    }
                    numberOfArea++;
                    if(maxSizeOfOneArea < cnt) maxSizeOfOneArea = cnt;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        //new Solution().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        new Solution().solution(3, 3, new int[][]{{0, 1, 0}, {1, 1, 0}, {0, 0, 0}});
    }
}
