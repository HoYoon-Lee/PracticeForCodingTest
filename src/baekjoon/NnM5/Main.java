package baekjoon.NnM5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;
    private static boolean[] visit;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" ")), m = Integer.parseInt(st.nextToken());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        visit = new boolean[n];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        printNumbers(n, m, "");

        br.close();
        bw.close();
    }

    private static void printNumbers(int n, int cnt, String s) throws IOException{
        if(cnt == 0){
            bw.write(s + "\n");
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visit[i]) {
                visit[i] = true;
                printNumbers(n, cnt - 1, s + numbers[i] + " ");
                visit[i] = false;
            }
        }
    }
}
