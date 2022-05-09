package programmers.lv1_실패율;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer;
        Map<Integer, Double> failureRate = new HashMap<>();
        int userCount = stages.length;

        for(int i = 1; i <= N; i++) {
            int level = i;
            int userAtLevel = Long.valueOf(Arrays.stream(stages).filter(s -> s == level).count()).intValue();
            failureRate.put(i, (double)userAtLevel / userCount);
            userCount -= userAtLevel;
        }

        answer = failureRate.entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> o1 < o2? 1 : o1 > o2? -1 : 0))
                .map(Map.Entry::getKey).mapToInt(i -> i).toArray();
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        new Solution().solution(5, stages);
    }
}