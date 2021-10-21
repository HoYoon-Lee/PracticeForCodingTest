package baekjoon.selfNumber;

import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> nonSelfNumbers = new HashSet<>();

        for(int i = 1; i < 10000; i++){
            String n = String.valueOf(i);
            int res = i;
            for(String j : n.split("")){
                res += Integer.valueOf(j);
            }
            if(res < 10000)
                nonSelfNumbers.add(res);
        }

        for(int i = 1; i < 10000; i++){
            if(!nonSelfNumbers.contains(i)) System.out.println(i);
        }
    }
}
