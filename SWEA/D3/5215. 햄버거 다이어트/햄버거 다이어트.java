import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int[] foodPoint, calories;
    static int count, caloriesLimit, max;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            count = Integer.parseInt(st.nextToken()); // 재료수
            caloriesLimit = Integer.parseInt(st.nextToken()); // 칼로리 제한

            foodPoint = new int[count];
            calories = new int[count];

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                foodPoint[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            max = 0;
            DFS(0, 0, 0);

            sb.append("#").append(test_case).append(" ").append(max).append("\n");

        }
        System.out.println(sb);

    }

    static void DFS(int idx, int totalScore, int totalCal) {

        if (totalCal > caloriesLimit) {
            return;
        }

        if (idx == count) {
            max = Math.max(totalScore, max);
            return;
        }

        DFS(idx + 1, totalScore + foodPoint[idx], totalCal + calories[idx]);

        DFS(idx + 1, totalScore, totalCal);

    }
}
