package programmers.immigration;

import java.util.Arrays;

class Solution {
    public long solution(long n, int[] times) {
        long answer = Long.MAX_VALUE;
        long high = Arrays.stream(times).max().getAsInt() * n, low = 1, mid, guest;


        while(high >= low){
            mid = low + ((high - low) / 2);
            guest = 0;
            for(int time : times){
                guest += (mid / time);
            }
            if(guest >= n) {
                high = mid - 1;
                answer = mid - answer > 0 ? answer : mid;
            }
            else low = mid + 1;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] times = {4, 2, 7};
        long res = new Solution().solution(10, times);
        System.out.println(res);
    }
}
