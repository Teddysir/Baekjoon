import java.io.*;
import java.util.*;

public class Main {

    public static Integer[] dp;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];

        arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(solution(N));
    }

    static int solution(int N) {
        if(N >= 2) {
            if (dp[N] == null) {
                dp[N] = Math.max(solution(N - 2) , (solution(N - 3) + arr[N - 1])) + arr[N];
            }
        }
        return dp[N];
    }


}

