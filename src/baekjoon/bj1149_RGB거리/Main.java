package baekjoon.bj1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] prices = new int[n][], total = new int[n][3];

        for(int i = 0; i < n; i++)
            prices[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        total[0] = Arrays.copyOf(prices[0], 3);

        for(int i = 1; i < n; i++)
            for(int j = 0; j < 3; j++)
                total[i][j] = Math.min(total[i - 1][(j + 1) % 3], total[i - 1][(j + 2) % 3]) + prices[i][j];
        System.out.println(Math.min(Math.min(total[n - 1][0], total[n - 1][1]), total[n - 1][2]));
    }
}
