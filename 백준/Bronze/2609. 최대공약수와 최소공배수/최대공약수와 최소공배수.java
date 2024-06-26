import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int num = 0;
        if (A > B) {
            num = A;
        } else {
            num = B;
        }

        int[] arr = new int[num+1];

        for (int i = 1; i <= num; i++) {
            if (A % i == 0 && B % i == 0) {
                arr[i] = i;
            }
        }

        int result = Arrays.stream(arr).max().orElse(0);
        System.out.println(result);
        System.out.println(A*B/result);

    }
}