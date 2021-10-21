package programmers.phoncketmon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = (HashSet)Arrays.stream(nums).boxed().collect(Collectors.toSet());

        answer = nums.length / 2 < set.size() ? nums.length / 2 : set.size();

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
