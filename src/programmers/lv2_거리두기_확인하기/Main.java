package programmers.lv2_거리두기_확인하기;

import java.util.Arrays;

class Solution {
    private final int[] upDown = {-1, 1, 0, 0};
    private final int[] leftRight = {0, 0, -1, 1};
    private final String person = "P";
    private final String empty = "O";
    private final String partition = "X";

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int p = 0; p < places.length; p++){
            int check = 1;
            String[][] room = Arrays.stream(places[p]).map(a -> a.split("")).toArray(String[][]::new);
            Checking:
            for(int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    if(room[i][j].equals(partition)) continue;
                    int cnt = 0;
                    for (int move = 0; move < 4; move++) {
                        int x = i + upDown[move];
                        int y = j + leftRight[move];
                        if(x < 0 || room.length <= x || y < 0 || room[i].length <= y) continue;
                        switch (room[i][j]) {
                            case person:
                                if (room[x][y].equals(person)) {
                                    check = 0;
                                    break Checking;
                                }
                                break;
                            case empty:
                                if (room[x][y].equals(person))
                                    cnt++;
                                if (cnt == 2) {
                                    check = 0;
                                    break Checking;
                                }
                                break;
                        }
                    }
                }
            }
            answer[p] = check;
        }

        return answer;
    }
}

//class Solution {
//    private final int[] upDown = {1, 2, 0, 0, -1, 1};
//    private final int[] leftRight = {0, 0, -2, -1, -1, -1};
//    private final int[][][] checkPoints = {{}, {{1, 0}}, {{0, -1}}, {}, {{-1, 0}, {0, -1}}, {{1, 0}, {0, -1}}};
//    private final int length = 5;
//    private final String person = "P";
//    private final String partition = "X";
//    private final String empty = "O";
//
//    public int[] solution(String[][] places) {
//        List<Integer> answer = new ArrayList<>();
//
//        for(String[] place : places){
//            int checkCompliance = 1;
//            String[][] room = Arrays.stream(place).map(a -> a.split("")).toArray(String[][]::new);
//
//            CheckingRoom:
//            for(int i = 0; i < length; i++){
//                for(int j = 0; j < length; j++){
//                    if(room[i][j].equals(person)){
//                        for(int move = 0; move < upDown.length; move++){
//                            int x = i + upDown[move];
//                            int y = j + leftRight[move];
//
//                            if(0 <= x && x < length && 0 <= y && y < length && room[x][y].equals(person)){
//                                for(int[] checkPoint : checkPoints[move]){
//                                    if(room[i + checkPoint[0]][j + checkPoint[1]].equals(empty)){
//                                        checkCompliance = 0;
//                                        break CheckingRoom;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            answer.add(checkCompliance);
//        }
//
//        return answer.stream().mapToInt(i -> i).toArray();
//    }
//}

public class Main {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        new Solution().solution(places);
    }
}
