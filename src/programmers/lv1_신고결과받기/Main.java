package programmers.lv1_신고결과받기;

import java.util.*;

class User{
    private final String name;
    private Integer count = 0;
    private Set<String> reporters = new HashSet<>();
    private Set<User> reported = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    private int getCount(){
        return count;
    }

    private boolean addCount(String reporter){
        if(!reporters.add(reporter))
            return false;
        count++;
        return true;
    }

    public void report(User user){
        if(reported.contains(user))
            return;
        reported.add(user);
        user.addCount(name);
    }

    public int countMail(int k){
        return Long.valueOf(reported.stream().filter(user -> user.getCount() >= k).count()).intValue();
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, User> users = new HashMap<>();

        Arrays.stream(id_list).forEach(id -> users.put(id, new User(id)));

        for(String r : report){
            String[] record = r.split(" ");
            users.get(record[0]).report(users.get(record[1]));
        }

        for(int i = 0; i < id_list.length; i++)
            answer[i] = users.get(id_list[i]).countMail(k);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}