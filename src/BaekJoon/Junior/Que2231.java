package BaekJoon.Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Que2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 글자를 입력받는애

        int M = Integer.parseInt(br.readLine()); // 216

        int N = 0;

        for (int i = 0; i < M; i++) {
            int num = i; // 0~ 216
            int sum = 0; // 0

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if(i+sum == M) {
                N = i;
                break;
            }

        }
        System.out.println(N);
    }
}
