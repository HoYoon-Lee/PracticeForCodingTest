package programmers.deletePair;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<String> remains = new Stack<>();
        String[] splits = s.split("");

        for (int i = 0; i < splits.length; i++){
            String now = splits[i];
            if(i + 1 < splits.length && now.equals(splits[i + 1])){
                i++;
            }
            else if(!remains.isEmpty() && now.equals(remains.peek())){
                remains.pop();
            }
            else{
                remains.push(now);
            }
        }

        if(remains.isEmpty()) answer = 1;

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("baabaa");
    }
}
