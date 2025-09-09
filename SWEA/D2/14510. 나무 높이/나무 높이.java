import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, ans, max;
	static int[] trees;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());
			ans = 0;
			trees = new int[N];
			max = -1;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if (trees[i] > max) {
					max = trees[i];
				}
			}
			solution();

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void solution() {

		int day_1 = 0;
		int day_2 = 0;

		for (int i = 0; i < N; i++) {
			int check = max - trees[i];
			day_2 += (check / 2);
			day_1 += (check % 2);
		}

		while (day_1 + 1 < day_2) {
			day_2--;
			day_1 += 2;
		}

		if (day_1 > day_2) {
			ans += (day_2 + day_1) + (day_1 - day_2) - 1;
		} else if (day_2 > day_1) {
			ans += (day_2 + day_1) + (day_2 - day_1);
		} else {
			ans += day_2 + day_1;
		}

	}

}
