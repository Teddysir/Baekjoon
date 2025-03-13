import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] arr;
    static int right, left;
    static int ansL, ansR;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        System.out.println(arr[ansL] + " " + arr[ansR]);

    }

    static void solution() {
        right = N - 1; // 제일 마지막 원소 idx
        left = 0;
        ansL = 0;
        ansR = 0;

        long min = Long.MAX_VALUE;

        while (right > left) { // 조건을 어떻게 설정해주어야할까?

            long sum = arr[right] + arr[left];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansL = left;
                ansR = right;
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
    }

}
