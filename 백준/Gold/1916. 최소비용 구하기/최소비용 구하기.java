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
	static int N, M;
	static int[] dist;
	static List<Node>[] graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 정점의 수
		M = Integer.parseInt(br.readLine()); // 간선의 수

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) { // 이렇게 일단 다 만들어주고
			graph[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) { // 간선 입력 받아주기
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, weight));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		djikstar(start);

		System.out.println(dist[end]);
	}

	static void djikstar(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.weight > dist[cur.next])
				continue;

			for (Node nextNode : graph[cur.next]) {
				int newWeight = cur.weight + nextNode.weight;

				if (newWeight < dist[nextNode.next]) {
					dist[nextNode.next] = newWeight;
					pq.add(new Node(nextNode.next, newWeight));
				}
			}
		}
	}

}
