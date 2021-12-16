package baekjoon.bj1932_정수삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input, record;

        record = new int[]{Integer.parseInt(br.readLine())};
        while (--n > 0){
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] tmp = new int[input.length];

            tmp[0] = input[0] + record[0];
            tmp[input.length - 1] = input[input.length - 1] + record[input.length - 2];
            for(int i = 1; i < input.length - 1; i++)
                tmp[i] = input[i] + Math.max(record[i - 1], record[i]);
            record = tmp;
        }
        System.out.println(Arrays.stream(record).max().getAsInt());
        br.close();
    }
}
