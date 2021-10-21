package baekjoon.getPrimeNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.valueOf(st.nextToken(" ")), to = Integer.valueOf(st.nextToken(" "));
        if(from == 1) from = 2;

        MainLoop:
        for(int i = from; i <= to; i++){
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0) continue MainLoop;
            }
            System.out.println(i);
        }
    }
}
