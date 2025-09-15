
import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			swap(start, end);

		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}

	static void swap(int start, int end) {

		int[] new_arr = new int[end - start + 2];

		int cur = 1;
		for (int i = end; i >= start; i--) {
			new_arr[cur] = arr[i];
			cur++;
		}

		int cur_2 = 1;
		for (int i = start; i <= end; i++) {
			arr[i] = new_arr[cur_2];
			cur_2++;
		}

	}
}
