package programmers.lv2_메뉴_리뉴얼;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    Map<String, Integer> count = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for(String order : orders)
            findSet(order.split(""), Arrays.stream(course).boxed().collect(Collectors.toList()), 0, "");

        for(int c : course) {
            List<Map.Entry<String, Integer>> collect = count.entrySet().stream()
                    .filter(e -> e.getKey().length() == c)
                    .collect(Collectors.toList());
            int max = collect.stream().max(Comparator.comparingInt(Map.Entry::getValue))
                    .orElse(new AbstractMap.SimpleEntry<>("", 0))
                    .getValue();

            if(max > 1)
                answer = Stream.concat(answer.stream(), collect.stream()
                        .filter(e -> e.getValue() == max)
                        .map(Map.Entry::getKey))
                        .collect(Collectors.toList());
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private void findSet(String[] menus, List<Integer> course, int start, String key){
        int n = key.length();
        if(course.contains(n)) {
            key = Arrays.stream(key.split("")).sorted().collect(Collectors.joining());
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        if(course.stream().max(Integer::compareTo).get() < key.length())
            return;

        for(int i = start; i < menus.length; i++)
            findSet(menus, course, i + 1, key + menus[i]);
    }
}

public class Main {
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2,3,5};
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2,3,4};
        new Solution().solution(orders, course);
    }
}
