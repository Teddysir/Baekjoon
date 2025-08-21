import java.io.*;
import java.util.*;

public class Solution {

	static int TC, startR, startC, endR, endC, ans;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int k = 1; k <= 10; k++) {

			TC = Integer.parseInt(br.readLine());

			map = new int[100][100];
			visited = new boolean[100][100];
			flag = false;
			ans = 0;

			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = input.charAt(j) - 48;
					if (map[i][j] == 2) {
						startR = i;
						startC = j;
					}
					if (map[i][j] == 3) {
						endR = i;
						endC = j;
					}
				}
			}
			bfs(startR, startC);

			if (flag) {
				ans = 1;
			}

			sb.append("#").append(TC).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];

				if (nr == endR && nc == endC) {
					flag = true;
					return;
				}

				if (nr >= 0 && nc >= 0 && nr < 100 && nc < 100 && !visited[nr][nc] && map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}

	}

}
