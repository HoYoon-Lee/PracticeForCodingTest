package baekjoon.stringRepetition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lineNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineNumber; i++) {
            String[] splits = br.readLine().split(" ");
            int q = Integer.valueOf(splits[0]);

            for (String s : splits[1].split("")) {
                for (int j = 0; j < q; j++) System.out.print(s);
            }
            System.out.println();
        }
    }
}