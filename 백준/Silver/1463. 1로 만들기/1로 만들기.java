import java.io.*;
import java.util.*;

public class Main {

    public static Integer[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Integer[N + 1];
        arr[0] = arr[1] = 0;

        System.out.println(solution(N));

    }

    static int solution(int N) {

        if (arr[N] == null) {
            if (N % 6 == 0) {
                arr[N] = Math.min(solution(N - 1), Math.min(solution(N / 3), solution(N / 2))) + 1;
            } else if (N % 3 == 0) {
                arr[N] = Math.min(solution(N / 3), solution(N - 1)) + 1;
            } else if (N % 2 == 0) {
                arr[N] = Math.min(solution(N / 2), solution(N - 1)) + 1;
            } else {
                arr[N] = solution(N - 1) + 1;
            }
        }
        return arr[N];
    }
    //  N = 2 = arr[2] = 1;
    // N = 3 = arr[3] = 1
    // N = 4 = arr[4] = 2
    // N = 5 = arr[5] = 3
    // N = 6 = arr[6] = 2
    // N = 7 = arr[7] = 3

}
