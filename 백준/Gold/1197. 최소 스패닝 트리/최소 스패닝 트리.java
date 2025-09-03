
import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static long ans;
	static boolean[] visited;
	static List<Edge>[] adjList;

	static class Edge implements Comparable<Edge> {

		int to;
		long weight;

		Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			adjList[from].add(new Edge(to, weight));
			adjList[to].add(new Edge(from, weight));

		}
		prim(1);

		System.out.println(ans);

	}

	static void prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {

			Edge e = pq.poll();

			if (visited[e.to]) {
				continue;
			}

			visited[e.to] = true;
			ans += e.weight;

			for (Edge edge : adjList[e.to]) {
				if (!visited[edge.to]) {
					pq.add(new Edge(edge.to, edge.weight));
				}
			}
		}
	}

}
