package baekjoon.groupWordChecker;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;

        MainLoop:
        for(int n = 0; n < num; n++){
            String s = br.readLine();
            Set<Character> characters = new HashSet<>();
            char c = s.charAt(0);
            for(int i = 1; i < s.length(); i++){
                char next = s.charAt(i);
                if(c != next){
                    if(characters.contains(next))
                        continue MainLoop;
                    characters.add(c);
                    c = next;
                }
            }
            answer++;
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        br.close();
        bw.close();
    }
}
