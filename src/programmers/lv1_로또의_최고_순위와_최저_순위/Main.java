package programmers.lv1_로또의_최고_순위와_최저_순위;

import java.util.Arrays;

class Solution {
    private final int[] rank = {6, 6, 5, 4, 3, 2, 1};

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int unknown = Long.valueOf(Arrays.stream(lottos).filter(i -> i == 0).count()).intValue();
        int correct = Long.valueOf(Arrays.stream(lottos).filter(i -> Arrays.stream(win_nums).anyMatch(j -> j == i)).count()).intValue();

        answer[0] = rank[correct + unknown];
        answer[1] = rank[correct];
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] result = new Solution().solution(lottos, win_nums);

        Arrays.stream(result).forEach(i -> System.out.print(i + " "));
    }
}
