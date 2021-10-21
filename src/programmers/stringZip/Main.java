package programmers.stringZip;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <= s.length() / 2; i++){
            String cipher = "";
            int count = 1;
            String std = s.substring(0, i);
            for(int j = i; j < s.length(); j += i){
                if(j + i > s.length()){
                    cipher += s.substring(j);
                    break;
                }
                String comp = s.substring(j, j + i);
                if(std.equals(comp)){
                    count++;
                }
                else{
                    if(count > 1)
                        cipher += count + std;
                    else
                        cipher += std;

                    std = comp;
                    count = 1;
                }
            }
            if(count > 1)
                cipher += count + std;
            else
                cipher += std;

            if(answer > cipher.length())
                answer = cipher.length();
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("abcabcdede");
    }
}
