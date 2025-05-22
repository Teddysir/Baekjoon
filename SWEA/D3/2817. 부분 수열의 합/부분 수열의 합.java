import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int T, N, K, count;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // N개의 자연수
            K = Integer.parseInt(st.nextToken()); // 합을 구해야하는 값 K

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            count = 0;

            DFS(0, 0);


            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);

    }

    static void DFS(int num, int idx) {

        if (idx == N) {
            if (num == K) {
                count++;
            }
            return;
        }

        DFS(num, idx + 1);

        DFS(num + arr[idx], idx + 1);

    }


}


