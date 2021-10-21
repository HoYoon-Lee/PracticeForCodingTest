package programmers.sorting2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> numberList = new ArrayList(Arrays.asList(Arrays.stream(numbers).mapToObj(String::valueOf).toArray()));

        numberList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.parseInt(o1.substring(0, 1)) > Integer.parseInt(o2.substring(0, 1))){
                    return -1;
                }
                else if(Integer.parseInt(o1.substring(0, 1)) < Integer.parseInt(o2.substring(0, 1))){
                    return 1;
                }
                else{
                    int idx1 = 0, idx2 = 0;
                    while(true){
                        if(o1.length() - 1 > idx1){
                            idx1++;
                        }

                        if(o2.length() - 1 > idx2){
                            idx2++;
                        }

                        if(Integer.parseInt(o1.substring(idx1, idx1 + 1)) > Integer.parseInt(o2.substring(idx2, idx2 + 1))){
                            return -1;
                        }
                        else if(Integer.parseInt(o1.substring(idx1, idx1 + 1)) < Integer.parseInt(o2.substring(idx2, idx2 + 1))){
                            return 1;
                        }
                    }
                }
            }
        });

        for(String num : numberList){
            answer += num;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
