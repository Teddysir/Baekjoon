import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;

            for (int i = 2; i < N - 2; i++) {
                int maxLeft;
                int maxRight;

                int value_1 = arr[i] - arr[i - 2];
                int value_2 = arr[i] - arr[i - 1];
                maxLeft = Math.min(value_1, value_2);

                int plus_value_1 = arr[i] - arr[i + 1];
                int plus_value_2 = arr[i] - arr[i + 2];
                maxRight = Math.min(plus_value_1, plus_value_2);

                if (maxLeft > 0 && maxRight > 0) {
                    count += Math.min(maxLeft, maxRight);
                }
            }


            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);


    }
}

