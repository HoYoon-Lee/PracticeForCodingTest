package programmers.skillCheck.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        ArrayList<ArrayList<int[]>> areas = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0){
                    int[] point = new int[]{i, j, picture[i][j]};
                    for(ArrayList<int[]> area : areas){
                        if(area.contains(point)){
                            point = null;
                            break;
                        }
                    }
                    if(point != null){
                        ArrayList<int[]> area = findArea(picture, point);
                        areas.add(area);
                    }
                }
            }
        }

        numberOfArea = areas.size();
        maxSizeOfOneArea = areas.stream().max(Comparator.comparingInt(ArrayList::size)).get().size();

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    ArrayList<int[]> findArea(int[][] picture, int[] start){
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> area = new ArrayList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int[] point = q.poll();

            //오른쪽
            if(point[1] + 1 < picture[0].length && picture[point[0]][point[1] + 1] == point[2]){
                q.offer(new int[]{point[0], point[1] + 1, point[2]});
            }

            //아래쪽
            if(point[0] + 1 < picture.length && picture[point[0] + 1][point[1]] == point[2]){
                q.offer(new int[]{point[0] + 1, point[1], point[2]});
            }
            area.add(point);
        }

        return area;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }
}
