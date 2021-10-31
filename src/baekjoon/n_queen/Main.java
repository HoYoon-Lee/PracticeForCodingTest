package baekjoon.n_queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        queens = new int[n];
        Arrays.fill(queens, -1);

        int res = getNumberOfCases(n, 0);
        System.out.println(res);
    }

    private static int getNumberOfCases(int n, int qCnt){
        int cases = 0;

        if(qCnt == n) return 1;

        LoopI:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < qCnt; j++){
                if(i == queens[j] || Math.abs(qCnt - j) == Math.abs(i - queens[j]))
                    continue LoopI;
            }
            queens[qCnt] = i;
            cases += getNumberOfCases(n, qCnt + 1);
        }
        return cases;
    }
}
