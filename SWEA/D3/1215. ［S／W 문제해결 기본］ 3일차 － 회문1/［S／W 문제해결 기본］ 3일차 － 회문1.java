import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static char[][] map;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {

            N = Integer.parseInt(br.readLine());

            map = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String input = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            int count = 0;

            for (int i = 0; i < 8; i++) {
                StringBuilder sb1 = new StringBuilder();

                for (int k = 0; k < 8; k++) {
                    sb1.append(map[i][k]);
                }

                for (int j = 0; j <= 8 - N; j++) {
                    if (rotateStringChecker(j, N + j - 1, sb1.toString())) {
                        count++;
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                StringBuilder sb2 = new StringBuilder();

                for (int k = 0; k < 8; k++) {
                    sb2.append(map[k][i]);
                }

                for (int j = 0; j <= 8 - N; j++) {
                    if (rotateStringChecker(j, N + j - 1, sb2.toString())) {
                        count++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);

    }

    static boolean rotateStringChecker(int startIdx, int endIdx, String input) {

        boolean ans = true;

        char[] arr1 = new char[N / 2];
        char[] arr2 = new char[N / 2];

        for (int i = 0; i < N / 2; i++) { // 0, 1
            arr1[i] = input.charAt(startIdx + i); // 3, 4
        }

        for (int i = 0; i < N / 2; i++) {
            arr2[i] = input.charAt(endIdx - i);
        }

        for (int i = 0; i < N / 2; i++) {
            if (arr1[i] != arr2[i]) {
                ans = false;
                break;
            }
        }

        return ans;
    }

}
