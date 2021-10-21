package baekjoon.sugarDelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());

        for(int i = total / 5; i >= 0; i--){
            if((total - (5 * i)) % 3 == 0){
                System.out.println(i + ((total - (5 * i)) / 3));
                return;
            }
        }

        System.out.println(-1);
    }
}
