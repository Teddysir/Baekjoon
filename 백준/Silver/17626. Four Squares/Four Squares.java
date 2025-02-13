import java.io.*;
import java.util.*;

public class Main {

    public static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        // dp[1] + 1, dp[2] = 2
        // dp[2] + 1, dp[3]
        System.out.println(dp[N]);

    }

}

