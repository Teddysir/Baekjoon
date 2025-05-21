import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] map;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {

            N = Integer.parseInt(br.readLine()); // 항상 100

            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < 100; i++) {

                boolean check = true;

                for (int j = 0; j < 100; j++) {

                    if (map[j][i] == 1) {
                        check = false;
                    } else if (map[j][i] == 2) {
//                        if (!check) {
                            if (!check) {
                                count++;
                                check = true;
                            }
//                        }
                    }

                }

            }


            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);

    }


}


