package baekjoon.coordinateAlignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate>{
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getCoordinate(){
        return this.x + " " + this.y;
    }

    @Override
    public int compareTo(Coordinate o) {
        if(this.x != o.x) return this.x - o.x;
        return this.y - o.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        ArrayList<Coordinate> coordis = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordis.add(new Coordinate(Integer.valueOf(st.nextToken(" ")), Integer.valueOf(st.nextToken())));
        }
        Collections.sort(coordis);

        for(Coordinate c : coordis){
            System.out.println(c.getCoordinate());
        }
    }
}