import java.util.*;
import java.io.*;

public class Solution {

	static int T, N;
	static String[] arr;
	static List<String> list_1;
	static List<String> list_2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {

			N = Integer.parseInt(br.readLine());

			arr = new String[N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}

			list_1 = new ArrayList<>();
			list_2 = new ArrayList<>();

			if (N % 2 == 1) {
				for (int i = 0; i <= N / 2; i++) {
					list_1.add(arr[i]);
				}

				for (int i = N / 2 + 1; i < N; i++) {
					list_2.add(arr[i]);
				}
			} else {
				for (int i = 0; i < N / 2; i++) {
					list_1.add(arr[i]);
				}

				for (int i = N / 2; i < N; i++) {
					list_2.add(arr[i]);
				}
			}

			sb.append("#").append(TC).append(" ");
			int total_count = 0;
			int count_1 = 0;
			int count_2 = 0;
			while (total_count != N) {

				if (total_count % 2 == 0) {
					sb.append(list_1.get(count_1)).append(" ");
					count_1++;
				} else {
					sb.append(list_2.get(count_2)).append(" ");
					count_2++;
				}
				total_count++;
			}
			sb.append("\n");

			
		}
		System.out.println(sb);
	}

}
