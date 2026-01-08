import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans;
    static int[] arr;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        num = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 1;

        while (end <= N) {

            while (num[arr[end]] >= K) {
                num[arr[start]]--;
                start++;
            }
            num[arr[end]]++;
            ans = Math.max(ans, end - start + 1);
            end++;

        }

        System.out.println(ans);

    }
}

// start, end 0 0 초기화하고 end가 전진하는 조건은 -> end가 start보다 작거나 같을떄
// 근데 만약 전진했는데 m_count 값이 K보다 커지면 start가 전진