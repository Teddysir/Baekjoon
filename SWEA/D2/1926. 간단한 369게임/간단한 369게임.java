import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String strNum = String.valueOf(i);
            int hyphenCount = 0;
            if (strNum.contains("3") || strNum.contains("9") || strNum.contains("6")) {
                for(int j = 0 ; j < strNum.length(); j++ ){
                    char charStr = strNum.charAt(j);
                    if(charStr == '3' || charStr== '6' || charStr== '9') {
                        hyphenCount++;
                    }
                }
                for(int j = 0 ; j < hyphenCount; j++ ){
                    sb.append("-");
                }
                sb.append(" ");
            } else {
                sb.append(strNum).append(" ");
            }
        }


        System.out.println(sb);
    }


}