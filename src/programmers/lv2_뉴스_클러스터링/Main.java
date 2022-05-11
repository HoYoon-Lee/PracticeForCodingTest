package programmers.lv2_뉴스_클러스터링;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final int N = 65536;

    public int solution(String str1, String str2) {
        List<String> strings1 = getStringSetList(str1);
        List<String> strings2 = getStringSetList(str2);

        int unSize = strings1.size() + strings2.size();
        int isSize = getIntersectionCount(strings1, strings2);

        return Double.valueOf(Math.floor((unSize == 0? 1 : (double) isSize / (unSize - isSize)) * N)).intValue();
    }

    private List<String> getStringSetList(String str){
        List<String> strings = new ArrayList<>();

        for(int i = 0; i < str.length() - 1; i++){
            String s = str.substring(i, i + 2);
            if(s.matches("[a-zA-Z]+"))
                strings.add(s.toLowerCase());
        }
        return strings;
    }

    private int getIntersectionCount(List<String> str1, List<String> str2){
        int cnt = 0;
        for(String s1 : str1){
            for(String s2 : str2){
                if(s1.equals(s2)){
                    cnt++;
                    str2.remove(s2);
                    break;
                }
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("BAAAA", "AAA");
//        new Solution().solution("FRANCE", "french");
    }
}
