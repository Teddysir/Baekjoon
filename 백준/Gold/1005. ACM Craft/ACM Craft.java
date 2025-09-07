import java.io.*;
import java.util.*;

public class Main {

	static int T, ans;
	static int N, K, target;

	static List<Integer>[] graph;
	static List<Integer> answer;
	static int[] inDegree;
	static int[] resultTime;

	static int[] time;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			ans = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			graph = new ArrayList[N + 1];
			inDegree = new int[N + 1];
			resultTime = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph[a].add(b);
				inDegree[b]++;

			}
			target = Integer.parseInt(br.readLine()); // 목표 건물
			topology();

			System.out.println(resultTime[target]);

		}

	}

	static void topology() {

		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) { // 진입 차수가 0 인 애들찾고 다 넣기
				q.add(i);
				resultTime[i] = time[i];
			}
		}

		while (!q.isEmpty()) {

			int temp = q.poll();

			for (int next : graph[temp]) {
				inDegree[next] -= 1;
				resultTime[next] = Math.max(resultTime[next], resultTime[temp] + time[next]);
				if (inDegree[next] == 0) {
					q.add(next);
				}
			}
		}

	}

}
