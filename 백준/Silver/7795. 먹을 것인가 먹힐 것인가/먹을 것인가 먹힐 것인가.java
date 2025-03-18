import java.io.*;
import java.util.*;

public class Main {

    static int[] A;
    static int[] B;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int countA = Integer.parseInt(st.nextToken());
            int countB = Integer.parseInt(st.nextToken());

            A = new int[countA];
            B = new int[countB];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < countA; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < countB; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            count = 0;
            for (int j = 0; j < countA; j++) {
                binarySearch(A[j], B);
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }

    static void binarySearch(int num, int[] arr) {
        int right = arr.length - 1;
        int left = 0;
        int cnt = 0;

        while (right >= left) {
            int mid = (right + left) / 2;

            if (arr[mid] >= num) { // 중간값이 찾는값보다 크다면? //같은값은 뺴고 작은값만 찾아야함
                right = mid - 1;
            } else {
                left = mid + 1;
                cnt = mid + 1; // 만약 +1한다면 그만큼 작은 갯수가 존재한다는거니 cnt도 mid+1로 초기화
            }
        }
        count += cnt; // while 끝나며 cnt갯수만큼 count 초기화
    }

}
