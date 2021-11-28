package baekjoon.bj11725_트리의부모찾기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] parents = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n - 1; i++){
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(!map.containsKey(tmp[0])) map.put(tmp[0], new ArrayList<>());
            map.get(tmp[0]).add(tmp[1]);
            if(!map.containsKey(tmp[1])) map.put(tmp[1], new ArrayList<>());
            map.get(tmp[1]).add(tmp[0]);

        }
        br.close();

        q.offer(1);
        while (!q.isEmpty()){
            int parent = q.poll();
            for(int child : map.get(parent)) {
                if (parents[child] == 0) {
                    parents[child] = parent;
                    q.offer(child);
                }
            }
        }

        for(int i = 2; i <= n; i++)
            bw.write(parents[i] + "\n");
        bw.close();
    }
}
