import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;
	static boolean[] visited;
	static List<Integer> team;

	static int INF = 100_100_100;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					map[i][j] = 0; // 자기자신이면 0
				} else {
					map[i][j] = INF; // 일단 최대로 갱신
				}
			}
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		visited = new boolean[N + 1];
		team = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {

				List<Integer> cur_team = new ArrayList<Integer>();
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != INF) {
						cur_team.add(j);
						visited[j] = true;
					}
				}

				int representive = -1;
				int min_Max_Time = Integer.MAX_VALUE;

				for (int j = 0; j < cur_team.size(); j++) {
					int temp_member = cur_team.get(j);
					int max_time = 0;

					for (int k = 0; k < cur_team.size(); k++) {
						int other_member = cur_team.get(k);
						max_time = Math.max(max_time, map[temp_member][other_member]);
					}

					if (min_Max_Time > max_time) {
						min_Max_Time = max_time;
						representive = temp_member;
					}
				}
				team.add(representive);

			}
		}

		Collections.sort(team);

		System.out.println(team.size());
		for (int i = 0; i < team.size(); i++) {
			System.out.println(team.get(i));
		}

	}

}