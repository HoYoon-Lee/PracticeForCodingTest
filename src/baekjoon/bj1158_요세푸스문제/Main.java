package baekjoon.bj1158_요세푸스문제;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" ")), k = Integer.parseInt(st.nextToken());
        boolean[] circle = new boolean[n];
        Arrays.fill(circle, false);
        int p = -1, cnt = 0;

        bw.write("<");
        while (true){
            // 남아있는 k째 사람을 찾을 때까지 p 증가
            for(int i = 0; i < k; i++){
                p = ++p % n;
                if(circle[p]) i--;
            }
            circle[p] = true; // p번째 사람 제거
            cnt++; // 카운트 증가
            bw.write(String.valueOf(p + 1)); // p 출력
            if(cnt < n) { // 마지막이 아닌 경우 ", " 출력
                bw.write(", ");
            }
            else { // 마지막인 경우 ">"를 출력하고 루프 종료
                bw.write(">");
                break;
            }
        }

        br.close();
        bw.close();
    }
}
