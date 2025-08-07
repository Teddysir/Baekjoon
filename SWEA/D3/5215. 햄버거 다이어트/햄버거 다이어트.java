import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

			powerSet(0, new boolean[burger]);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static void powerSet(int cnt, boolean[] selected) {

		if (cnt == burger) {
			int temp = 0;
			int tmpCalorie = 0;

			for (int i = 0; i < burger; i++) {
				if (selected[i]) {
					temp += tastes[i];
					tmpCalorie += calories[i];
				}
			}
			if (tmpCalorie < limit_calories) {
				ans = Math.max(temp, ans);
			}

			return;
		}

		selected[cnt] = true;
		powerSet(cnt + 1, selected);

		selected[cnt] = false;
		powerSet(cnt + 1, selected);

	}

}
