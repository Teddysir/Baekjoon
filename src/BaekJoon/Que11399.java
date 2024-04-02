package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Que11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람의 수 받기

        int Per[] = new int[N];

        for (int i = 0; i < N; i++) {
            Per[i] = sc.nextInt();
        }

        Arrays.sort(Per);

        int total = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += Per[i]; // 각 사람들의 누적 이용 시간을 계산
            total += sum; // 누적 이용 시간의 총합 계산
        }
        System.out.println("최소 시간은 : " + total);
    }

}
