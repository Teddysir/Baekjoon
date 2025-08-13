import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int[] fee;
	static int[] day;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			fee = new int[5];
			for (int i = 1; i <= 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}

			day = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				day[i] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;
			cal(0, 0);
			sb.append("#").append(k).append(" ").append(Math.min(fee[4], ans)).append("\n");
		}

		System.out.println(sb);

	}

	static void cal(int cnt, int temp_fee) {

		if (cnt >= 12) {
			ans = Math.min(temp_fee, ans);
			return;
		}

		// days[cnt] * fee[1]; cnt++;
		// days[cnt] * fee[2]; cnt++;
		// days[cnt] * fee[3]; cnt + 3\\

		cal(cnt + 1, temp_fee + fee[1] * day[cnt + 1]);

		cal(cnt + 1, temp_fee + fee[2]);

		if (cnt + 3 <= 12) {
			cal(cnt + 3, temp_fee + fee[3]);
		} 

	}

}
