import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static int T, N;
	static long ans;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int max = arr[N - 1]; // 최대값 초기화
			ans = 0;

			for (int k = N - 2; k >= 0; k--) {
				if (max > arr[k]) {
					ans += (max - arr[k]);
				} else {
					max = arr[k];
				}
			}

			sb.append(ans).append("\n");

		}

		System.out.println(sb);

	}

}
