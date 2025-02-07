import java.io.*;
import java.util.*;

public class Main {

    public static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = -1;
        }

        arr[0] = 0;
        arr[1] = 1;

        System.out.println(solution(N));


    }

    public static long solution(int N) {
        if (arr[N] == -1) {
            arr[N] = solution(N - 1) + solution(N - 2);
        }
        return arr[N];
    }

}


