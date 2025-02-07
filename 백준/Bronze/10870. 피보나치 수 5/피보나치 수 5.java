import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = -1;
        }


        System.out.println(solution(N));

    }

    public static int solution(int N) {

        if(N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        if (arr[N] == -1) {
            arr[N] = solution(N - 1) + solution(N - 2);
        }
        return arr[N];
    }

}


