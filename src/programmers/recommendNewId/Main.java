package programmers.recommendNewId;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1단계
        answer = new_id.toLowerCase();
        // 2단계
        answer = answer.replaceAll("[^a-z0-9_\\-\\.]", "");
        // 3단계
        answer = answer.replaceAll("\\.+", ".");
        // 4단계
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1);
        }
        if(answer.length() > 1 && answer.charAt(answer.length() - 1) == '.'){
            answer = answer.substring(0, answer.length() - 1);
        }
        // 5단계
        if(answer.isBlank()){
            answer = "a";
        }
        // 6단계
        if(answer.length() > 15){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.'){
                answer = answer.substring(0, 14);
            }
        }
        // 7단계
        String e = answer.substring(answer.length() - 1);
        while (answer.length() < 3){
            answer += e;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("abcdefghijklmn.p");
    }
}
