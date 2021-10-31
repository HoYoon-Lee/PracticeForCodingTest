package baekjoon.flyMeToTheAlphaCentauri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] xy;
        int[] ds = new int[t];

        for(int i = 0; i < t; i++){
            xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ds[i] = xy[1] - xy[0];
        }

        for(int d : ds){
            int sqrt = (int)Math.sqrt(d);
            int left = d - (sqrt * sqrt);
            int cnt = sqrt + (sqrt - 1);

            for(int i = sqrt; i > 0; i--){
                cnt += left / i;
                left %= i;
            }

            System.out.println(cnt);
        }
    }
}
