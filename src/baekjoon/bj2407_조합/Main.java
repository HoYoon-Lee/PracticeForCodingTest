package baekjoon.bj2407_조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" ")), m = Integer.parseInt(st.nextToken());
        BigInteger n1 = BigInteger.ONE, n2 = BigInteger.ONE;

        for(int i = Math.max(m, n - m) + 1; i <= n; i++)
            n1 = n1.multiply(BigInteger.valueOf(i));
        for(int i = 2; i <= Math.min(m, n - m); i++)
            n2 = n2.multiply(BigInteger.valueOf(i));

        System.out.println(n1.divide(n2));

        br.close();
    }
}
