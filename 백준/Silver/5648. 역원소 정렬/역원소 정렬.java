import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        arr = new long[N];
        int idx = 0;

        while (true) {
            if (st.hasMoreTokens()) {
                StringBuilder input = new StringBuilder(st.nextToken());
                arr[idx++] = Long.parseLong(input.reverse().toString());
                if (idx == N) break;
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);


    }

}
