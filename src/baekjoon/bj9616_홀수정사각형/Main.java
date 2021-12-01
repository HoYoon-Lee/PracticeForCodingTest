package baekjoon.bj9616_홀수정사각형;

import java.io.*;
import java.util.StringTokenizer;

// 시간 초과
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long m = Integer.parseInt(st.nextToken(" ")) + 1, n = Integer.parseInt(st.nextToken()) + 1;
            long cnt = 0, min = Math.min(m, n);
            if(m == 1 && n == 1) break;

//            for(long i = 0; i < m - 1; i++){
//                for(long j = 1; i + j <= min; j++){
//                    long length = i + j;
//                    if(((i * i) + (j * j)) % 2 == 1){
//                        cnt += (m - length) * (n - length);
//                    }
//                }
//            }
            bw.write(cnt + "\n");
        }
        br.close();
        bw.close();
    }
}
