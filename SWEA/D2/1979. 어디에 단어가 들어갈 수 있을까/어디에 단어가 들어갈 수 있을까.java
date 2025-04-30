import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int M = Integer.parseInt(st.nextToken());
            int strLength = Integer.parseInt(st.nextToken());

            map = new int[M][M];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = 0;

            for (int i = 0; i < M; i++) {
                int checkCount = 0;
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        checkCount++;
                    } else if (map[i][j] == 0) {
                        if (checkCount == strLength) {
                            ans++;
                        }
                        checkCount = 0;
                    }
                }
                if (checkCount == strLength) {
                    ans++;
                }

            }

            for (int j = 0; j < M; j++) {
                int checkCount = 0;
                for (int i = 0; i < M; i++) {
                    if (map[i][j] == 1) {
                        checkCount++;
                    } else if (map[i][j] == 0) {
                        if (checkCount == strLength) {
                            ans++;
                        }
                        checkCount = 0;
                    }
                }
                if (checkCount == strLength) {
                    ans++;
                }
            }


            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);

    }


}