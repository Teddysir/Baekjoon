package Practice;
// 맨 끝 숫자는 0이여야함.
// 각 자리 수의 합이 3으로 나누어 떨어져야 한다 ***
// 반ㄷ시 0이 있어야한다.
// ex) 562 = 5 + 6 + 2 13 이건안되네
// ex) 5073 = 5 + 0 + 7 + 3 = 15 and 0도 있음.

import java.util.*;
public class Que10610 {
    public static final int Max = 100000;

    public static String str;
    public static int[] numCountArr;
    public static long strLen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        strLen = str.length();
        numCountArr = new int[10];
        long total = 0;
        for (int i = 0; i < strLen; i++) {
            int tNum = Integer.parseInt(str.substring(i,i+1));
            numCountArr[tNum] += 1;
            total += tNum;
        }
        if(!str.contains("0") || total % 3 != 0){
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0 ; i--) {
            while(numCountArr[i] > 0){
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
