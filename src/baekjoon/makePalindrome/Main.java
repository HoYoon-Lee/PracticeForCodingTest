package baekjoon.makePalindrome;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int answer = 0;

        for(int i = (int)Math.ceil(s.length() / 2.0); i < s.length(); i++){
            String front = s.substring(0, i);
            String back = new StringBuffer(s.substring(i)).reverse().toString();

            if(Pattern.matches("^.*" + back + ".?$", front)){
                answer = front.length() * 2;
                if(Pattern.matches("^.*" + back + ".$", front)) answer--;
                break;
            }
        }
        if(answer == 0) answer = (s.length() * 2) - 1;
        bw.write(String.valueOf(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
