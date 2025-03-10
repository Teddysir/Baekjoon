import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int max;
    static List<Integer> sum = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        max = -1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(sum);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (arr[i] > arr[j]) {
                    int idx = Collections.binarySearch(sum, arr[i] - arr[j]);
                    if (idx >= 0) {
                        max = Math.max(max, arr[i]);
                    }
                }
            }
        }


        System.out.println(max);

    }


}
