package programmers.hash3;

import java.util.Arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;

        /*HashMap<String, ArrayList<String>> clothesMap = new HashMap<String, ArrayList<String>>();

        for(String[] element : clothes) {
        	if(!clothesMap.containsKey(element[1])) {
        		clothesMap.put(element[1], new ArrayList<String>());
        	}
        	clothesMap.get(element[1]).add(element[0]);
        }

        for(String key : clothesMap.keySet()) {
        	answer *= clothesMap.get(key).size() + 1;
        }
        answer--;

        return answer;*/
    }
}
