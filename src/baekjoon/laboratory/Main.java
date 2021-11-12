package baekjoon.laboratory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] map;
    private static List<int[]> viruses = new ArrayList<>();
    private static int[] rowCheck = {-1, 1, 0, 0}, colCheck = {0, 0, -1, 1};
    private static int blank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[nm[0]][nm[1]];
        blank = (nm[0] * nm[1]) - 3; // 전체 칸 개수 - 추가할 벽 3개

        for(int i = 0; i < nm[0]; i++){
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < nm[1]; j++){
                map[i][j] = Integer.parseInt(ss[j]);
                switch (map[i][j]){
                    case 2: // 2이면 바이러스 좌표에 추가하고 빈칸 개수 줄이기
                        viruses.add(new int[]{i, j});
                    case 1: // 1이면 빈칸 개수만 즐이기
                        blank--;
                        break;
                }
            }
        }
        br.close();

        int res = getMaxSafeArea(nm[0], nm[1], 0, 0, 3);
        System.out.println(res);
    }

    private static int getMaxSafeArea(int n, int m, int r, int c, int cnt){
        int max = 0;

        // 벽이 다 설치되지 않은 경우
        if(cnt > 0) {
            // 이전에 설치한 벽을 기준으로 이후 빈칸들에 차례대로 벽 설치
            for (int i = r; i < n; i++) {
                for (int j = (i == r ? c : 0); j < m; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        max = Math.max(max, getMaxSafeArea(n, m, i, j, cnt - 1));
                        map[i][j] = 0;
                    }
                }
            }
        }
        // 벽이 다 설치된 경우
        else {
            List<int[]> l = new ArrayList<>();

            // 바이러스 루프
            for (int[] virus : viruses) {
                Queue<int[]> q = new LinkedList<>();
                q.offer(virus);
                // 바이러스 주변 빈칸 탐색
                while (!q.isEmpty()) {
                    int[] xy = q.poll();
                    int x = xy[0], y = xy[1];
                    for (int i = 0; i < 4; i++) {
                        int row = x + rowCheck[i], col = y + colCheck[i];
                        if (0 <= row && row < n && 0 <= col && col < m && map[row][col] == 0) { // 빈칸을 찾으면
                            map[row][col] = 2; // 2로 바꾸고
                            int[] nextXy = new int[]{row, col};
                            q.offer(nextXy); // 큐에 추가
                            l.add(nextXy); // 나중에 되돌리기 위해 리스트에 추가
                        }
                    }
                }
            }
            max = blank - l.size(); // 빈칸 크기 - 바이러스가 퍼진 빈칸 개수
            // 빈칸 원래대로 돌려놓기
            for (int[] xy : l) {
                map[xy[0]][xy[1]] = 0;
            }
        }
        return max;
    }
}
