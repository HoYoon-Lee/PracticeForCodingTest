package baekjoon.bj1629_곱셈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
        System.out.println(pow(a, b, c));
    }

    private static long pow(int a, int b, int c){
        if(b == 1) return a % c;
        long num = pow(a, b / 2, c);
        long res = (num * num) % c;
        if(b % 2 == 1)
            res = (res * a) % c;
        return res;
    }
}
