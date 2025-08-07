import java.io.*;
import java.util.*;

public class Solution {

	static int burger, limit_calories, TC, ans;
	static int[] tastes;
	static int[] calories;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			burger = Integer.parseInt(st.nextToken());
			limit_calories = Integer.parseInt(st.nextToken());

			ans = 0;
			tastes = new int[burger];
			calories = new int[burger];
		
			for (int i = 0; i < burger; i++) {
				st = new StringTokenizer(br.readLine());

				int taste = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());

				tastes[i] = taste;
				calories[i] = calorie;

			}
			dp(0, 0, 0);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static void dp(int cnt, int score, int calorie) {

		if (limit_calories < calorie) {
			return;
		}
		if (cnt == burger) {
			ans = Math.max(ans, score);
			return;
		}

		dp(cnt + 1, score + tastes[cnt], + calorie + calories[cnt]);
		
		dp(cnt +1, score, calorie);

	}

}
