import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N;
	static int[] posX;
	static int[] posY;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			posX = new int[N + 2];
			posY = new int[N + 2];
			posX[N + 1] = Integer.parseInt(st.nextToken());
			posY[N + 1] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N + 1; i++) {
				posX[i] = Integer.parseInt(st.nextToken());
				posY[i] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;

			solution(0, posX[0], posY[0], new boolean[N + 2], 0);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void solution(int cnt, int nx, int ny, boolean[] visited, int dist) {

		if (cnt == N) {
			dist += getDist(nx, posX[N + 1], ny, posY[N + 1]);
			ans = Math.min(dist, ans);
			return;
		}

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int temp = getDist(nx, posX[i], ny, posY[i]);
				solution(cnt + 1, posX[i], posY[i], visited, dist + temp);
				visited[i] = false;

			}
		}

	}

	static int getDist(int x1, int x2, int y1, int y2) { // 거리구하기
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
