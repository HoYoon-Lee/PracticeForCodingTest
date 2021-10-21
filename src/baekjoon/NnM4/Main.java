package baekjoon.NnM4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken(" ")), m = Integer.valueOf(st.nextToken());

        getAscendingCases(1, n, m, "");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void getAscendingCases(int start, int n, int m, String res) throws IOException{
        if(m == 0){
            bw.write(res + "\n");
            return;
        }
        for(int i = start; i <= n; i++){
            getAscendingCases(i, n, m - 1, res + i + " ");
        }
    }
}
