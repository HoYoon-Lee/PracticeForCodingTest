package baekjoon.hanSu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int cnt = 0;

        MainLoop:
        for(int i = 1; i <= n; i++){
            String[] r = String.valueOf(i).split("");
            if(r.length < 2) {
                cnt++;
                continue;
            }

            int gap = Integer.parseInt(r[1]) - Integer.parseInt(r[0]);

            for(int j = 2; j < r.length; j++){
                if(Integer.parseInt(r[j]) - Integer.parseInt(r[j - 1]) != gap){
                    continue MainLoop;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
