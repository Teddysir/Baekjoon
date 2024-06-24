import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);

    }

    static int search(int[] arr, int n, int m) {
        int result = 0;

        for (int i = 0; i < n - 2; i++) {

            for (int j = i+1; j < n - 1; j++) {

                for (int k = j+1; k < n; k++) {
                    int temp = arr[i] + arr[j] + arr[k];

                    if (m == temp) {
                        return temp;
                    }

                    if (result < temp && temp < m) {
                        result = temp;
                    }

                }
            }
        }

        return result;
    }
}