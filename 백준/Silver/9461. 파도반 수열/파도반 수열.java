import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            long[] arr = new long[num + 1];

            arr[0] = 0;
            arr[1] = 1;
            if (num > 1) {
                arr[2] = 1;
                for (int j = 3; j <= num; j++) {
                    arr[j] = arr[j - 3] + arr[j - 2];
                }
            }

            sb.append(arr[num]).append("\n");
        }

        System.out.println(sb);


    }
}

// 1, 1, 1, 2, 2, 3, 4, 5, 7, 9

// n = n-3 + n-2  / n > 3;

