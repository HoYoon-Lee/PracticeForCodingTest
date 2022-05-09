package programmers.lv1_숫자_문자열과_영단어;

class Solution {
    private final String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public int solution(String s) {
        for(int i = 0; i < numbers.length; i++)
            s = s.replaceAll(numbers[i], String.valueOf(i));

        return Integer.parseInt(s);
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("one4seveneight");
    }
}
