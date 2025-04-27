import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 전체 칸
            map = new int[N][N]; // 맵

            M = Integer.parseInt(st.nextToken()); // 잡을 칸

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int count = 0;
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            count += map[k][l];
                        }
                    }
                    if (count > max) {
                        max = count;
                    }
                }
            }


            sb.append("#").append(test_case).append(" ").append(max).append("\n");


        }

        System.out.println(sb);
    }


}