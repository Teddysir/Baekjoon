import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int next;
		int weight;

		Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static StringTokenizer st;
	static int V, E, start;
	static List<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		dist = new int[V + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		start = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, weight));
		}


		djikstra(start);
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb);

	}

	static void djikstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.weight > dist[cur.next])
				continue;

			for (Node next : graph[cur.next]) {
				int newWeight = cur.weight + next.weight;

				if (newWeight < dist[next.next]) {
					dist[next.next] = newWeight;
					pq.add(new Node(next.next, newWeight));
				}
			}
		}

	}

}
