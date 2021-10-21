package programmers.targetNumber;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = findTargetNumber(numbers, 0, target, 0);

        return answer;
    }

    int findTargetNumber(int[] numbers, int n, int target, int total){
        if(n < numbers.length){
            return findTargetNumber(numbers, n + 1, target, total + numbers[n]) +
                    findTargetNumber(numbers, n + 1, target, total - numbers[n]);
        }

        if(total == target) return 1;
        else return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
