package programmers.lv2_괄호_변환;

class Solution {
    public String solution(String p) {
        return getCorrectBracket(p);
    }

    private String getCorrectBracket(String s){
        if(s.isBlank()) return s;

        int cnt = 0;
        boolean isCorrect = true;
        String u = "", v = "";

        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    cnt++;
                    break;
                case ')':
                    cnt--;
                    break;
            }
            if(cnt < 0) isCorrect = false;
            if(cnt == 0) {
                u = s.substring(0, i + 1);
                v = getCorrectBracket(s.substring(i + 1));
                break;
            }
        }
        if(isCorrect) return u + v;
        return  "(" + v + ")"
                + u.substring(1, u.length() - 1)
                .replaceAll("\\(", "1").replaceAll("\\)", "2")
                .replaceAll("1", ")").replaceAll("2", "(");
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("()))((()");
    }
}
