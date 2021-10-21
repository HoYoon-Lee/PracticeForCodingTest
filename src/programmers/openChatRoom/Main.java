package programmers.openChatRoom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> nickNames = new HashMap<>();
        ArrayList<String> contents = new ArrayList<>();

        for(String s : record){
            if(s.startsWith("Enter") || s.startsWith("Change")) {
                String[] splits = s.split(" ");
                nickNames.put(splits[1], splits[2]);
            }
        }

        for(String s : record){
            if(s.startsWith("Enter") || s.startsWith("Leave")){
                String[] splits = s.split(" ");
                String c = nickNames.get(splits[1]);

                switch (splits[0]){
                    case "Enter":
                        c += "님이 들어왔습니다.";
                        break;
                    case "Leave":
                        c += "님이 나갔습니다.";
                        break;
                }
                contents.add(c);
            }
        }

        answer = contents.toArray(new String[contents.size()]);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
