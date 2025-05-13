import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int I = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= I; test_case++) {

            String input = br.readLine();

            String before;
            String after;

            if (input.length() % 2 != 0) {
                before = input.substring(0, input.length() / 2);
                after = input.substring(input.length() / 2 + 1);
            } else {
                before = input.substring(0, input.length() / 2);
                after = input.substring(input.length() / 2);
            }

            int check = 1;

            for(int i = 0 ; i < before.length(); i++ ){
                if(before.charAt(i) != after.charAt(before.length()-i-1)) {
                    check = 0;
                }
            }

            sb.append("#").append(test_case).append(" ").append(check).append("\n");

        }
        System.out.println(sb);


    }
}
