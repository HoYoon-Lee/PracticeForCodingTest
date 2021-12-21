package baekjoon.bj9465_스티커;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][], score = new int[n][3];

            for(int i = 0; i < 2; i++)
                stickers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            score[0][1] = stickers[0][0];
            score[0][2] = stickers[1][0];

            for(int i = 1; i < n; i++){
                score[i][0] = Math.max(score[i - 1][1], score[i - 1][2]);
                score[i][1] = stickers[0][i] + Math.max(score[i - 1][0], score[i - 1][2]);
                score[i][2] = stickers[1][i] + Math.max(score[i - 1][0], score[i - 1][1]);
            }
            bw.write(Arrays.stream(score[n - 1]).max().getAsInt() + "\n");
        }
        br.close();
        bw.close();
    }
}
