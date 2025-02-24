import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static String S;

//    static String defString = "I";
//    static String addString = "OI";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // P^n
        StringBuilder sb = new StringBuilder("I");

        for (int i = 0; i < N; i++) {
            sb.append("OI");
        }
        String input = sb.toString();

        M = Integer.parseInt(br.readLine());
        S = br.readLine(); // 여기다가 커스텀 IOIOIII 받고


        int count = 0;
        for (int i = 0; i < M - (input.length() - 1); i++) {
            if (S.substring(i, i + input.length()).equals(input)) {
                count++;
            }
        }

        System.out.println(count);


    }


}
