package programmers.farthestNode;

import java.util.*;

class Node{
    private int value;
    private List<Integer> connection = new ArrayList<>();

    public Node(int value){
        this.value = value;
    }

    public void addConnection(int value){
        this.connection.add(value);
    }

    public List<Integer> getConnection() {
        return connection;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && ((Node) obj).value == this.value;
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer;
        List<Node> nodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] shortest = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i = 0; i < n; i++){
            nodes.add(new Node(i));
        }

        for(int[] e : edge){
            nodes.get(e[0] - 1).addConnection(e[1] - 1);
            nodes.get(e[1] - 1).addConnection(e[0] - 1);
        }
        q.offer(0);
        visited[0] = true;
        int cnt = 0, parentCnt = 1, childCnt = 0;

        while (!q.isEmpty()){
            int value = q.poll();
            shortest[value] = cnt;
            parentCnt--;

            for(int nv : nodes.get(value).getConnection()){
                if(!visited[nv]) {
                    q.offer(nv);
                    visited[nv] = true;
                    childCnt++;
                }
            }

            if(parentCnt == 0){
                cnt++;
                parentCnt = childCnt;
                childCnt = 0;
            }
        }

        Arrays.sort(shortest);
        int max = shortest[shortest.length - 1];
        answer = (int)Arrays.stream(shortest).filter(i -> i == max).count();

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}
