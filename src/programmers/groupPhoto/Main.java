package programmers.groupPhoto;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    final int MAX = 8;

    class Req{
        // 해당되는 프렌즈
        String p1, p2;
        //간격의 시작과 끝 (범위에 포함)
        int from, to;

        public Req(String p1, String p2, String op, int gap) {
            if(p1.compareTo(p2) < 0) {
                this.p1 = p1;
                this.p2 = p2;
            }
            else {
                this.p1 = p2;
                this.p2 = p1;
            }

            switch (op){
                case "=":
                    this.from = gap;
                    this.to = gap;
                    break;
                case ">": // 이상
                    this.from = gap + 1;
                    this.to = MAX -  2;
                    break;
                case "<": // 이하
                    this.to = gap - 1;
                    break;
            }
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Req && ((Req) obj).p1.equals(p1) && ((Req) obj).p2.equals(p2);
        }
    }

    public int solution(int n, String[] data) {
        int answer = 1;
        ArrayList<String> friends = new ArrayList<>(Arrays.asList(new String[]{"A", "C", "F", "J", "M", "N", "R", "T"}));
        ArrayList<Req> check = new ArrayList<>();

        // 요구사항 정리 및 확인
        for(String s : data){
            String split[] = s.split("");

            Req nr = new Req(split[0], split[2], split[3], Integer.parseInt(split[4]));

            if(check.contains(nr)){
                Req or = check.get(check.indexOf(nr));

                or.from = or.from < nr.from ? nr.from : or.from;
                or.to = nr.to < or.to ? nr.to : or.to;

                if(or.to < or.from)
                    return 0;
            }
            else{
                check.add(nr);
            }
        }

        //경우의 수 계산
        answer = permutation(friends, new ArrayList<String>(), check);

        return answer;
    }

    // 경우의 수 재귀함수
    public int permutation(ArrayList<String> friends, ArrayList<String> perm, ArrayList<Req> reqs){
        for(Req r : reqs){
            if(perm.contains(r.p1) && perm.contains(r.p2)) {
                int diff = Math.abs(perm.indexOf(r.p1) - perm.indexOf(r.p2)) - 1;
                if (!(r.from <= diff && diff <= r.to)) {
                    return 0;
                }
            }
        }

        if(perm.size() < MAX){
            int answer = 0;
            for(String f : friends) {
                ArrayList<String> remains = new ArrayList<>(friends);
                remains.remove(f);
                ArrayList<String> next = new ArrayList<>(perm);
                next.add(f);
                answer += permutation(remains, next, reqs);
            }
            return answer;
        }
        else{
            return 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String data[] = {"N~F=0", "R~T>2"};

        System.out.println(new Solution().solution(2, data));
    }
}
