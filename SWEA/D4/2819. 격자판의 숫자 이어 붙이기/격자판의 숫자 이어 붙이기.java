import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static char[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static Set<Integer> set;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			map = new char[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = (char) (Integer.parseInt(st.nextToken()) + 48);
				}
			}
			set = new HashSet<Integer>();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					bfs(i, j, "", map[i][j]);
				}
			}

			sb.append("#").append(k).append(" ").append(set.size()).append("\n");

		}
		System.out.println(sb);
	}

	static void bfs(int r, int c, String num, char append) {
		StringBuilder temp_sb = new StringBuilder();
		num = String.valueOf(temp_sb.append(num).append(append));

		if (num.length() == 7) {
			set.add(Integer.parseInt(String.valueOf(num)));
			return;
		} else {

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < 4 && nc < 4) {
					bfs(nr, nc, num, map[nr][nc]);
				}
			}

		}

	}

}
