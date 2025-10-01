import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<Integer>[] list;
	static int[] num;
	static int[] indegree;

	static int[] result;

	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		num = new int[N + 1];
		indegree = new int[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());

			int next = Integer.parseInt(st.nextToken());
			if (next == -1) {
				continue;
			} else {
				list[next].add(i);
				indegree[i]++;
				while (true) {
					int num = Integer.parseInt(st.nextToken());
					if (num == -1) {
						break;
					} else {
						list[num].add(i);
					}
					indegree[i]++;
				}
			}
		}

		solution();

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}

	}

	static void solution() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				result[i] = num[i]; // 결과값은 일단 자신의 건물수로 초기
			}
		}

		while (!q.isEmpty()) {

			int cur = q.poll();

			for (int next : list[cur]) {
				result[next] = Math.max(result[next], result[cur] + num[next]);

				indegree[next]--;
				if (indegree[next] == 0) {
					q.add(next);
				}
			}

		}

	}

}