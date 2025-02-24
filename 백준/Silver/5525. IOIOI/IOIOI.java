import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static String S;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // P^n
        M = Integer.parseInt(br.readLine()); // 문자열 길이
        S = br.readLine(); // 여기다가 커스텀 IOIOIII 받고

        int count = 0;
        int result = 0;

        for(int i = 1; i < M-1; i++) {
            if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                count++;

                if(count >= N) {
                    result++;
                }
                i++;
            } else {
                count = 0;
            }
        }

        System.out.println(result);
//        for (int i = 0; i < M - (input.length() - 1); i++) {
//            if (S.substring(i, i + input.length()).equals(input)) {
//            if (S.startsWith(input, i)) {
//                count++;
//            }
//        }

    }


}
