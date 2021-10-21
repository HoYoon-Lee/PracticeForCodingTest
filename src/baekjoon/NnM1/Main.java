package baekjoon.NnM1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static Boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken(" ")), m = Integer.valueOf(st.nextToken());
        visit = new Boolean[n];
        Arrays.fill(visit, false);

        getPermutation(m, "");
    }

    public static void getPermutation(int cnt, String res) {
        if (cnt == 0) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                getPermutation(cnt - 1, res + (i + 1) + " ");
                visit[i] = false;
            }
        }
    }
}
