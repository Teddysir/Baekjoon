import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] map;
    static String[][] newMap;
    static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {

            M = Integer.parseInt(br.readLine());

            map = new int[M][M];
            newMap = new String[M][3];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            angle90(map);
            angle180(map);
            angle270(map);

            sb.append("#").append(test_case).append("\n");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(newMap[i][j]).append(" ");
                }
                sb.append("\n");
            }


        }

        System.out.println(sb);

    }

    static void angle90(int[][] map) {

        for (int i = 0; i < M; i++) { // 2
            StringBuilder sb = new StringBuilder();
            for (int j = M - 1; j >= 0; j--) { // 2
                sb.append(map[j][i]);
            }
            newMap[i][0] = String.valueOf(sb);
        }

    }

    static void angle180(int[][] map) {

        for (int i = M - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = M - 1; j >= 0; j--) {
                sb.append(map[i][j]);
            }
            newMap[M - i - 1][1] = String.valueOf(sb);
        }

    }

    static void angle270(int[][] map) {

        for (int i = M - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(map[j][i]);
            }
            newMap[M - i - 1][2] = String.valueOf(sb);
        }
    }


}

