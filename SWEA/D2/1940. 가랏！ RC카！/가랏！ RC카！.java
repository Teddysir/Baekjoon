import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {

            int command = Integer.parseInt(br.readLine());

            int nowSpeed = 0;
            int nowDistance = 0;
            for (int i = 0; i < command; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken()); // 0, 1, 2중 선택 -> 0 유지 -> 1 가속 -> 2 감속

                if (N == 1) {
                    int value = Integer.parseInt(st.nextToken()); // 몇 가속/감속 할지 입력받음
                    nowSpeed += value;
                } else if (N == 2) {
                    int value = Integer.parseInt(st.nextToken()); // 몇 가속/감속 할지 입력받음
                    if (nowSpeed < value) {
                        nowSpeed = 0;
                    } else {
                        nowSpeed -= value;
                    }
                }

                nowDistance += nowSpeed;

            }

            sb.append("#").append(test_case).append(" ").append(nowDistance).append("\n");

        }
        System.out.println(sb);


    }
}
