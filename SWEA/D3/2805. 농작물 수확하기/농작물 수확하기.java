import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[][] map;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
                }
            }
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == (N / 2) - i) {
                        for (int k = (N / 2) - i; k <= (N / 2) + i; k++) {
                            count += map[i][k];
                        }
                    }
                    if( j == (N/2) + (N-i-1)) {
                        for(int k = (N/2)-(N-i-1); k <= (N/2)+(N-i-1); k++ ){
                            count += map[i][k];
                        }
                    }
                }
            }

            for(int i = 0; i < N; i++ ){
                count -= map[N/2][i];
            }


            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);

    }

}
