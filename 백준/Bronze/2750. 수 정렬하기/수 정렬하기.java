import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }

}
