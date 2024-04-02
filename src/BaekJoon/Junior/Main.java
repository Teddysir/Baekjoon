package BaekJoon.Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 글자를 입력받는애

        int N = Integer.parseInt(br.readLine());

        int range = 2;
        int level = 1;

        if(N == 1) {
            System.out.print(1);
        } else {
            while(range <= N) {
                range = range + (6 * level); // 14까지 20까지 26까지
                level++;
            }
            System.out.println(level);
        }
        // 복습
    }
}