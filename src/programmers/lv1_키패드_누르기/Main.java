package programmers.lv1_키패드_누르기;

class Solution {
    private final int[][] numberPad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
    private final String[] hands = {"L", "R"};
    private int[] left = {3, 0};
    private int[] right = {3, 2};

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        hand = hand.equals("left")? hands[0] : hands[1];

        for(int number : numbers){
            int[] target = numberPad[number];
            answer.append(selectHand(target, hand));
        }

        return answer.toString();
    }

    private String selectHand(int[] target, String hand){
        switch (target[1]){
            case 0:
                hand = hands[0];
                break;
            case 2:
                hand = hands[1];
                break;
            default:
                int distanceWithLeft = getDistance(target, left);
                int distanceWithRight = getDistance(target, right);

                if(distanceWithLeft < distanceWithRight)
                    hand = hands[0];
                else if (distanceWithLeft > distanceWithRight)
                    hand = hands[1];
        }
        if(hand.equals(hands[0]))
            left = target;
        else
            right = target;
        return hand;
    }

    private int getDistance(int[] first, int[] second){
        return Math.abs(first[0] - second[0]) + Math.abs(first[1] - second[1]);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
