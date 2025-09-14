import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N;
	static List<long[]> point;
	static long ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			N = Integer.parseInt(br.readLine());
			ans = Long.MAX_VALUE;

			point = new ArrayList<long[]>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				long r = Integer.parseInt(st.nextToken());
				long c = Integer.parseInt(st.nextToken());
				point.add(new long[] { r, c });

			}
			combination(0, 0, new boolean[N]);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static void combination(int startIdx, int cnt, boolean[] selected) {

		if (cnt == N / 2) {

			long totalX = 0;
			long totalY = 0;

			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					totalX -= point.get(i)[0];
					totalY -= point.get(i)[1];
				} else {
					totalX += point.get(i)[0];
					totalY += point.get(i)[1];
				}
			}

			long tempAns = (totalX * totalX) + (totalY * totalY);
			ans = Math.min(tempAns, ans);
			return;
		}

		for (int i = startIdx; i < N; i++) {

			selected[i] = true;
			combination(i + 1, cnt + 1, selected);
			selected[i] = false;

		}

	}

}
