import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            int findNum = Integer.parseInt(st.nextToken());

            int originalX = x;
            int originalY = y;

            boolean aChecker = true;
            int aCount = 0;

            while (x <= findNum && y <= findNum) {

                if (aChecker) {
                    x = y + x;
                    aChecker = false;
                } else {
                    y = x + y;
                    aChecker = true;
                }

                aCount++;

            }

            boolean bChecker = true;
            int bCount = 0;

            while (originalX <= findNum && originalY <= findNum) {

                if (bChecker) {
                    originalY = originalX + originalY;
                    bChecker = false;
                } else {
                    originalX = originalY + originalX;
                    bChecker = true;
                }

                bCount++;
            }

            int count;

            if (aCount > bCount) {
                count = bCount;
            } else {
                count = aCount;
            }


            sb.append(count).append("\n");

        }
        System.out.println(sb);


    }
}
