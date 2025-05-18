import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();


        for (int test_case = 1; test_case <= 10; test_case++) {

            int changeCount = Integer.parseInt(br.readLine());

            int[] arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < changeCount; i++) {
                Arrays.sort(arr);
                arr[0] += 1;
                arr[99] -= 1;
            }

            Arrays.sort(arr);

            int count = arr[99] - arr[0];

            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);


    }
}
