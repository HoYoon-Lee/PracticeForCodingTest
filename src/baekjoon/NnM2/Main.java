package baekjoon.NnM2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static Boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken(" ")), m = Integer.valueOf(st.nextToken());

        visit = new Boolean[n];
        Arrays.fill(visit, false);

        getCombination(0, m, "");
    }

    public static void getCombination(int start, int m, String res){
        if(m == 0){
            System.out.println(res);
            return;
        }

        for(int i = start; i < visit.length; i++){
            visit[i] = true;
            getCombination(i + 1, m - 1, res + (i + 1) + " ");
            visit[i] = false;
        }
    }
}
