
import java.io.*;
import java.util.*;

public class Main {

	static int ans, V, E, start;
	static int[] dist;
	static List<Node>[] nodeList;

	static class Node implements Comparable<Node>{
		int to, weight;

		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			nodeList[i] = new ArrayList<Node>();
		}
		dist = new int[V + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		start = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodeList[from].add(new Node(to, weight));

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
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {

			Node temp = pq.poll();
			int nextTo = temp.to;
			int nextWeight = temp.weight;

			if (dist[nextTo] < nextWeight) {
				continue;
			}

			for (Node node : nodeList[nextTo]) {
				int next = node.weight + nextWeight;
				if (dist[node.to] > next) {
					dist[node.to] = next;
					pq.add(new Node(node.to, next));
				}
			}

		}

	}
}
