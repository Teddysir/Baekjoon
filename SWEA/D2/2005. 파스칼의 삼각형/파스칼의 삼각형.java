import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int M;
    static int[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {

            M = Integer.parseInt(br.readLine());

            map = new int[M+1][M+1];
            map[0][1] = 1;

            for (int i = 1; i <= M; i++) { // 처음엔 0

                for(int j = 1; j <= i; j++ ){
                    map[i][j] = map[i-1][j-1] + map[i-1][j];
                }
            }
            sb.append("#").append(test_case).append("\n");

            for(int i = 1;  i <= M; i++ ){
                for(int j = 1; j <= M; j++ ){
                    if(map[i][j] != 0) {
                        sb.append(map[i][j]).append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }


}

