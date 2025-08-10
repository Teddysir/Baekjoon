import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, L, ans;
	static int[] calories;
	static int[] tastes;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			calories = new int[N];
			tastes = new int[N];
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				tastes[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}

			solution(0, 0, 0);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static void solution(int cnt, int calorie, int score) {

		if (calorie > L) {
			return;
		}

		if (cnt == N) {
			ans = Math.max(ans, score);
			return;
		}

		solution(cnt + 1, calorie, score);
		solution(cnt + 1, calorie + calories[cnt], score + tastes[cnt]);

	}

}
