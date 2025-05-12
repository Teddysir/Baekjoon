import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int N, M;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr1 = new int[N];
            arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int maxValue = -1;

            if (N < M) {

                for (int j = 0; j <= M - N; j++) {
                    int value = 0;

                    for (int i = 0; i < N; i++) {
                        value += (arr1[i] * arr2[i + j]);
                    }

                    if (value > maxValue) {
                        maxValue = value;
                    }
                }

            } else {
                for (int j = 0; j <= N - M; j++) {
                    int value = 0;

                    for (int i = 0; i < M; i++) {
                        value += (arr1[i + j] * arr2[i]);
                    }
                    if (value > maxValue) {
                        maxValue = value;
                    }
                }

            }

            sb.append("#").append(test_case).append(" ").append(maxValue).append("\n");

        }
        System.out.println(sb);


    }
}
