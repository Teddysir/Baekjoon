import java.io.*;
import java.util.*;

public class Solution {

	static int ans, V, E;
	static List<Integer>[] graph;
	static int[] inDegree;
	static int[][] arr; // 방향 그래프 저장 배열도 줘야하나?
	static List<Integer> result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int k = 1; k <= 10; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			arr = new int[V + 1][V + 1];
			result = new ArrayList<Integer>();

			inDegree = new int[V + 1]; // 진입 차수 저장용
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E ; i++) {

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1; // a -> b 방향 저장 ?
				graph[a].add(b);
				inDegree[b]++; // b에 들어오는 진입 차수가 추가되었으니 증가

			}

			topology();
			sb.append("#").append(k).append(" ");

			for (int i = 0; i < V; i++) {
				sb.append(result.get(i)).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

	static void topology() {

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0) {
				q.add(i); // 일단 진입차수 0인 애들 먼저 넣고
			}
		}

		while (!q.isEmpty()) {

			int temp = q.poll();
			result.add(temp);

			for (int i = 0; i < graph[temp].size(); i++) {
				inDegree[graph[temp].get(i)] -= 1; // 해당 노드랑 연결된 하위 노드들의 진입차수를 1 빼주고
				if (inDegree[graph[temp].get(i)] == 0) {
					q.add(graph[temp].get(i)); // 만약 진입차수 -1 했는데 0이면 q에 넣고
				}
			}

		}

	}

}
