import java.io.*;
import java.util.*;

public class Main {

    static int N, M, count;
    static int[] arr; // 우선 배열에다가 모든 수를 넣고

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 재료의 개수
        M = Integer.parseInt(br.readLine()); // 만들어야 하는 수

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr); // 일단 모든 수가 들어있는 수임 그걸 정렬.
        solution();
        System.out.println(count);
    }

    static void solution() {

        int right = N - 1; // 5
        int left = 0;

        // 1 2 3 4 5 7
        while (right > left) {

            int sum = arr[left] + arr[right];

            if (sum == M) {
                count++;
                left++;
                right--;
            } else if (sum > M) {
                right--;
            } else {
                left++;
            }

        }
    }

}

