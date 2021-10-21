package programmers.hash1;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }

        for(String s : map.keySet()){
            if(map.get(s) != 0) answer = s;
        }

        return answer;
    }

    /*public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> check = new HashMap<String, Integer>();
        HashMap<Boolean, HashSet<String>> isChecked = new HashMap<Boolean, HashSet<String>>();

        for(String name : completion) {
            if(check.containsKey(name)) {
                check.replace(name, check.get(name) + 1);
            }
            else {
                check.put(name,  1);
            }
        }

        isChecked.put(true, new HashSet<String>());
        isChecked.put(false, new HashSet<String>());

        for(String name : participant) {
            if(check.containsKey(name)) {
                check.replace(name, check.get(name) - 1);
                if(check.get(name) == 0) {
                    isChecked.get(true).add(name);
                    if(isChecked.get(false).contains(name))
                        isChecked.get(false).remove(name);
                }
                else {
                    isChecked.get(false).add(name);
                }
            }
            else {
                answer = name;
                return answer;
            }
        }

        answer = isChecked.get(false).toArray()[0].toString();

        return answer;
    }*/

    public static void main(String[] args) {
        //String[] participant = {"leo", "kiki", "eden"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //String[] completion = {"eden", "kiki"};
        String[] completion = {"stanko", "ana", "mislav"};

        Solution solution = new Solution();
        System.out.println(solution.solution(participant, completion));
    }
}
