import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, size, minR, minC;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			size = Integer.parseInt(br.readLine());
			map = new int[size][size];

			for (int i = 0; i < size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			minR = 0;
			minC = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					visited = new boolean[size][size];
					int temp_ans = solution(i, j);

					if (ans == temp_ans) {
						if (map[minR][minC] > map[i][j]) {
							minR = i;
							minC = j;
						}
					}

					if (temp_ans > ans) {
						ans = temp_ans;
						minR = i;
						minC = j;
					}

				}
			}

			sb.append("#").append(k).append(" ").append(map[minR][minC]).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int solution(int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { row, col });
		visited[row][col] = true;

		int temp_ans = 1;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < size && nc < size && !visited[nr][nc]) {
					if (map[temp[0]][temp[1]] + 1 == map[nr][nc]) {
						temp_ans++;
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc });
					}
				}
			}
		}

		return temp_ans; // 최대로 이동할 수 있는

	}

}