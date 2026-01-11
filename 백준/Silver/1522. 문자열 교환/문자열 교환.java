import java.util.*;
import java.io.*;

public class Main {
    static char[] arr;
    static int size, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        arr = new char[input.length() * 2];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < input.length() * 2; i++) {
            arr[i] = input.charAt(i % input.length());
            if (arr[i] == 'a') size++;
        }

        for (int i = 0; i < (input.length() * 2) - (size / 2); i++) {
            int temp = 0;
            for (int j = i; j < i + (size / 2); j++) {
                if (arr[j] == 'b') temp++;
            }
            ans = Math.min(temp, ans);
        }
        System.out.println(ans);

    }
}
