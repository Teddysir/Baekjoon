import java.io.*;
import java.util.*;

public class Solution {

	static int ans, start, count;
	static boolean[] visited;

	static List<List<Integer>> list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int k = 1; k <= 10; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			count = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			visited = new boolean[101];

			list = new ArrayList<>();
			for (int i = 0; i < 101; i++) {
				list.add(new ArrayList<Integer>());
			}

			ans = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < count / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
			}

			bfs(start);

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			int temp_size = q.size();
			int temp_max = 0;

			for (int i = 0; i < temp_size; i++) {
				int cur = q.poll(); // 뽑고
				temp_max = Math.max(temp_max, cur);

				for (int j = 0; j < list.get(cur).size(); j++) {
					if (!visited[list.get(cur).get(j)]) {
						q.add(list.get(cur).get(j));
						visited[list.get(cur).get(j)] = true;
					}
				}
			}

			ans = temp_max;

		}

	}

}
