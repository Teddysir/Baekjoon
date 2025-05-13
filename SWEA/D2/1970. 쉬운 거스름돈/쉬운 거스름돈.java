import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {

            int inputNum = Integer.parseInt(br.readLine());

            int first_50000 = 0;
            int second_10000 = 0;
            int third_5000 = 0;
            int fourth_1000 = 0;
            int fifth_500 = 0;
            int sixth_100 = 0;
            int seventh_50 = 0;
            int eighth_10 = 0;

            if(inputNum >= 50000) {
                first_50000 += (inputNum / 50000);
                inputNum -= (first_50000 * 50000);
            }

            if(inputNum >= 10000) {
                second_10000 += (inputNum / 10000);
                inputNum -= (second_10000 * 10000);
            }

            if(inputNum >= 5000) {
                third_5000 += (inputNum / 5000);
                inputNum -= (third_5000 * 5000);
            }

            if(inputNum >= 1000) {
                fourth_1000 += (inputNum / 1000);
                inputNum -= (fourth_1000 * 1000);
            }

            if(inputNum >= 500) {
                fifth_500 += (inputNum / 500);
                inputNum -= (fifth_500 * 500);
            }

            if(inputNum >= 100) {
                sixth_100 += (inputNum / 100);
                inputNum -= (sixth_100 * 100);
            }

            if(inputNum >= 50) {
                seventh_50 += (inputNum / 50);
                inputNum -= (seventh_50 * 50);
            }

            if(inputNum >= 10) {
                eighth_10 += (inputNum / 10);
            }

            sb.append("#").append(test_case).append("\n");
            sb.append(first_50000).append(" ").append(second_10000).append(" ").append(third_5000).append(" ").append(fourth_1000).append(" ").append(fifth_500).append(" ").append(sixth_100).append(" ").append(seventh_50).append(" ").append(eighth_10).append("\n");

        }
        System.out.println(sb);


    }
}
