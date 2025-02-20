import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i] > max) {
                max = trees[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long total = 0;

            for (int tree : trees) {
                if (tree - mid > 0) {
                    total += (tree - mid);
                }
            }

            if (total < M) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min - 1);


    }


}
