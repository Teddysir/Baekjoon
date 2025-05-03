import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {


            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ansCount = 0;

            for (int i = 0; i < 9; i++) {
                int col = 0;
                int row = 0;
                for (int j = 0; j < 9; j++) {
                    col += map[i][j];
                    row += map[j][i];
                }
                if (col != 45 || row != 45) {
                    ansCount++;
                }
            }
            // 0  -2 // 3 -4 // 6 - 8
            // 00 01 02
            // 10 11 12
            // 20 21 22


            for (int i = 0; i < 9; i += 3) {
                for (int j = i; j < i + 3; j += 3) {

                    int cube = 0;
                    for(int col = 0; col < 3; col++){
                        for(int row = 0; row < 3; row++) {
                            cube += map[col+i][row+j];
                        }
                    }
                    if (cube != 45) {
                        ansCount++;
                    }
                }

            }


            int ans;
            if (ansCount != 0) {
                ans = 0;
            } else {
                ans = 1;
            }


            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);

    }


}