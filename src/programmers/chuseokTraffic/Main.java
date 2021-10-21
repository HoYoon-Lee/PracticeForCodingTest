package programmers.chuseokTraffic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        Queue<Long> starts = new PriorityQueue<>(), ends = new PriorityQueue<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        int cnt = 0;

        for(String line : lines){
            try {
                long end = simpleDateFormat.parse(line.substring(0, 23)).getTime();
                long start = (long) (end - ((Double.valueOf(line.substring(24, line.length() - 1)) * 1000) - 1));
                starts.offer(start);
                ends.offer(end + 1000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        while (!ends.isEmpty()){
            if(starts.isEmpty() || starts.peek() >= ends.peek()) {
                cnt--;
                ends.poll();
            }
            else{
                cnt++;
                answer = answer > cnt ? answer : cnt;
                starts.poll();
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"});
    }
}
