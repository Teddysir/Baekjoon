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

            int standard = 0;

            for(int i = 1 ; i < input.length(); i++ ){
                if(input.substring(0,i).equals(input.substring(i,i+standard+1))) {
                    break;
                } else {
                    standard++;
                }
            }

            sb.append("#").append(test_case).append(" ").append(standard+1).append("\n");

        }
        System.out.println(sb);


    }
}
