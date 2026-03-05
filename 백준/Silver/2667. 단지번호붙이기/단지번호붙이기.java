import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static int N, mapCount, cnt;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static List<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - 48;
			}
		}

//		System.out.println(Arrays.deepToString(map));

		cnt = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					ans.add(cnt);
					cnt = 1;
				}
			}
		}

		Collections.sort(ans);

		sb.append(ans.size()).append("\n");
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append("\n");
		}
		System.out.println(sb);

	}

	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
					cnt++;
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}

	}

}
