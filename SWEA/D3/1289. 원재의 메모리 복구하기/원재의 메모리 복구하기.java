import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int T, count;
    static String N;
    static char[] arr1, arr2;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            N = br.readLine(); // 비트 값

            int bitLength = N.length();

            arr1 = new char[bitLength];
            arr2 = new char[bitLength];



            for (int i = 0; i < bitLength; i++) {
                arr1[i] = N.charAt(i);
            }

            for (int i = 0; i < bitLength; i++) {
                arr2[i] = '0';
            }


            boolean check = true;
            count = 0;

            while (check) {
                int checkCount = 0;
                for (int i = 0; i < bitLength; i++) {
                    if (arr1[i] != arr2[i]) {
                        checkCount++;
                    }
                }

                if (checkCount != 0) {
                    checker();
                } else {
                    check = false;
                }
            }



            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.println(sb);

    }

    static void checker() {

        for(int i = 0; i < N.length();i++ ){
            if(arr1[i] != arr2[i]) {
                char temp = arr1[i];
                for(int j = i; j < N.length(); j++ ){
                    arr2[j] = temp;
                }
                count++;

            }
        }

    }


}


