package baekjoon.bj9251_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(""), b = br.readLine().split("");
        int[][] count = new int[a.length + 1][b.length + 1];
        int max = 0;

        for(int i = 1; i <= a.length; i++){
            for(int j = 1; j <= b.length; j++){
                if(a[i - 1].equals(b[j - 1])) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                    max = Math.max(max, count[i][j]);
                }
                else {
                    count[i][j] = Math.max(count[i][j - 1], count[i - 1][j]);
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}
