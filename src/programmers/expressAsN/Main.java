package programmers.expressAsN;

import java.util.ArrayList;

class Solution {
    int MAX_CNT = 8;

    public int solution(int N, int number) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        int n = N;
        for(int i = 0; i < MAX_CNT; i++){
            if(n == number) return i + 1;
            ArrayList<Integer> na = new ArrayList<>();
            na.add(n);
            results.add(na);
            n = (n * 10) + N;
        }

        for(int i = 1; i < results.size(); i++){
            for(int j = 0; j < i; j++){
                for(int x : results.get(j)){
                    for(int y : results.get(i - j - 1)){
                        results.get(i).add(x + y);
                        results.get(i).add(x - y);
                        results.get(i).add(x * y);
                        if(y != 0) results.get(i).add(x / y);
                    }
                }
            }
            if(results.get(i).contains(number)) return i + 1;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, 12));
    }
}
