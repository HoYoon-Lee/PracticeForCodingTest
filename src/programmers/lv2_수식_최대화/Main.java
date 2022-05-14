package programmers.lv2_수식_최대화;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    private final String[] OPERATOR = {"*", "-", "+"};
    private final int[][] operatorSets = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

    public long solution(String expression) {
        long answer = 0;

        for(int[] operatorSet : operatorSets){
            Queue<Long> numbers = Arrays.stream(expression.split("[*\\-+]"))
                    .mapToLong(Long::parseLong)
                    .boxed()
                    .collect(Collectors.toCollection(LinkedList::new));
            Queue<String> operators = Arrays.stream(expression.split("[0-9]+"))
                    .filter(op -> !op.isBlank())
                    .collect(Collectors.toCollection(LinkedList::new));

            long n = 0;

            for(int i : operatorSet){
                n = numbers.poll();
                int size = numbers.size();
                for(int s = 0; s < size; s++) {
                    String op = operators.poll();
                    if (op.equals(OPERATOR[i]))
                        n = calculate(n, numbers.poll(), OPERATOR[i]);
                    else {
                        numbers.offer(n);
                        n = numbers.poll();
                        operators.offer(op);
                    }
                }
                numbers.offer(n);
            }
            answer = Math.max(answer, Math.abs(n));
        }

        return answer;
    }

    private long calculate(long n1, long n2, String op) {
        switch (op){
            case "*":
                return n1 * n2;
            case "-":
                return n1 - n2;
            case "+":
                return n1 + n2;
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("100-200*300-500+20");
    }
}
