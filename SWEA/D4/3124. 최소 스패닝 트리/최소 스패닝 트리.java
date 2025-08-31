import java.io.*;
import java.util.*;

// PRIM은 정점을 기준으로 간선의 가중치가 작은 순서대로 길을 찾는 알고리즘이다.
// 즉 우선순위 큐를 이용하면서 간선의 가중치가 작은 순서대로 찾고 만약 방문한 노드라면 방문하지 않는다.

public class Solution {

	static int TC;
	static long ans;
	static int V, E;
	static List<Node>[] list;
	static boolean[] visited;

	static class Node implements Comparable<Node> {

		int to;
		long weight;

		Node(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Short.parseShort(br.readLine()); // 테케
		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V + 1];

			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<Node>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long cost = Long.parseLong(st.nextToken());

				list[a].add(new Node(b, cost));
				list[b].add(new Node(a, cost)); // 양방향 추가
			}
ans = 0;
			visited = new boolean[V + 1]; // ~ V;
			solution(1); // 시작 노드는 아무거나?
            

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void solution(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node temp = pq.poll();

			int v = temp.to;
			long cost = temp.weight;

			if (visited[v]) {
				continue;
			}

			ans += cost;
			visited[v] = true;

			for (Node n : list[v]) {
				if (!visited[n.to]) {
					pq.add(new Node(n.to, n.weight));
				}
			}

		}
	}

}
