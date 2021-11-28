package baekjoon.bj11053_가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), max = 0;
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] rising = new int[n];

        br.close();

        for(int i = 0; i < n; i++){
            int j = max - 1;
            for(; j >= 0 && a[i] <= rising[j]; j--);
            rising[++j] = a[i];
            if(max == j) max++;
        }
        System.out.println(max);
    }
}