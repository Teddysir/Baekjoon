import java.io.*;
import java.util.*;

public class Solution {

	static int TC, V, E;
	static long ans;
	static List<Edge>[] adjList;
	static boolean[] visited;

	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			ans = 0;
			visited = new boolean[V+1];
			adjList = new ArrayList[V+1];
			for (int i = 0; i < V+1; i++) {
				adjList[i] = new ArrayList<Edge>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				long weight = Integer.parseInt(st.nextToken());

				adjList[from].add(new Edge(to, weight));
				adjList[to].add(new Edge(from, weight));

			}
			prim(1, V);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void prim(int start, int n) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.to;
			long weight = edge.weight;
			if (visited[v])
				continue;

			visited[v] = true;
			ans += weight;

			for (Edge e : adjList[v]) {
				if (!visited[e.to]) {
					pq.add(new Edge(e.to, e.weight));
				}
			}
		}
	}

}
