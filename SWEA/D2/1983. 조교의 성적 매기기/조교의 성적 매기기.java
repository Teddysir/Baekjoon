import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static String A_PLUS = "A+";
    static String A_ZERO = "A0";
    static String A_MINUS = "A-";

    static String B_PLUS = "B+";
    static String B_ZERO = "B0";
    static String B_MINUS = "B-";

    static String C_PLUS = "C+";
    static String C_ZERO = "C0";
    static String C_MINUS = "C-";

    static String D_ZERO = "D0";

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int students = Integer.parseInt(st.nextToken());
            int findStudent = Integer.parseInt(st.nextToken());

            double[] studentArr = new double[students + 1];
            double[] sortArr = new double[students + 1];


            for (int i = 1; i <= students; i++) {
                st = new StringTokenizer(br.readLine());

                int middleTest = Integer.parseInt(st.nextToken());
                int finalTest = Integer.parseInt(st.nextToken());
                int homework = Integer.parseInt(st.nextToken());

                double score = scoreCalculator(middleTest, finalTest, homework);

                studentArr[i] = score;
                sortArr[i] = score;
            }

            Arrays.sort(sortArr);


            int level = -1;
            for (int i = 1; i <= students; i++) {
                if (studentArr[findStudent] == sortArr[i]) {
                    level = i;
                }
            }

            int standard = students / 10; // 20 이면 2 30이면 3

            String ans;
            if (level > standard * 9) {
                ans = A_PLUS;
            } else if (level > standard * 8) {
                ans = A_ZERO;
            } else if (level > standard * 7) {
                ans = A_MINUS;
            } else if (level > standard * 6) {
                ans = B_PLUS;
            } else if (level > standard * 5) {
                ans = B_ZERO;
            } else if (level > standard * 4) {
                ans = B_MINUS;
            } else if (level > standard * 3) {
                ans = C_PLUS;
            } else if (level > standard * 2) {
                ans = C_ZERO;
            } else if (level > standard) {
                ans = C_MINUS;
            } else {
                ans = D_ZERO;
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);

    }

    static double scoreCalculator(int middleTestScore, int finalTestScore, int homeworkScore) {

        return (middleTestScore * 0.35) + (finalTestScore * 0.45) + (homeworkScore * 0.2);
    }


}

