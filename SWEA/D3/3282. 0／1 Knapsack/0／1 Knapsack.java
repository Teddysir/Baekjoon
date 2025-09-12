import java.io.*;
import java.util.*;

public class Solution {
	static int TC, ans, limit, count;

	static int[] dp_1;
	static int[][] dp_2;

	static int[] volumes;
	static int[] values;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			count = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());

			volumes = new int[count];
			values = new int[count];

			dp_1 = new int[limit + 1]; // 1차원 디피 최대 무게
			dp_2 = new int[count][limit + 1]; // 2차원디피 최대무게

			for (int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());
				volumes[i] = Integer.parseInt(st.nextToken());
				values[i] = Integer.parseInt(st.nextToken());
			}

			dp_1_solution();
//			dp_2_solution();

			sb.append("#").append(t).append(" ").append(dp_1[limit]).append("\n");
		}

		System.out.println(sb);
	}

	static void dp_1_solution() {

		for (int i = 0; i < count; i++) {
			for (int j = limit; j >= volumes[i]; j--) {
				dp_1[j] = Math.max(dp_1[j], dp_1[j - volumes[i]] + values[i]);
			}
		}

	}

	static void dp_2_solution() {

	}

}
