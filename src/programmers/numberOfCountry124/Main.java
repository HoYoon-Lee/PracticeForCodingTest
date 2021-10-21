package programmers.numberOfCountry124;

class Solution {
    public String solution(int n) {
        String answer = "";

        do{
            int remains = n % 3;
            n /= 3;

            if(remains == 0) {
                remains = 4;
                n -= 1;
            }

            answer = String.valueOf(remains) + answer;
        }while (n >= 1);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(4);
    }
}
