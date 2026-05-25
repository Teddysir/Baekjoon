import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	static class Node implements Comparable<Node> {
		int next;
		long weight;

		public Node(int next, long weight) {
			this.next = next;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}

	}

	static List<Node>[] graph;
	static long[] dist;

	public static void main(String[] args) {

		Solution sol = new Solution();

		int N = 5;

		int[][] road = { { 1, 2, 1 }, { 2, 3, 3 }, { 5, 2, 2 }, { 1, 4, 2 }, { 5, 3, 1 }, { 5, 4, 2 } };

		int K = 3;

		System.out.println(sol.solution(N, road, K));
	}

	public int solution(int N, int[][] road, int K) {

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;

		for (int i = 0; i < road.length; i++) {
			int from = road[i][0];
			int to = road[i][1];
			long weight = road[i][2];

			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		djikstra();

		int answer = 0;

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K) {
				answer++;
			}
		}

		return answer;
	}

	public void djikstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Solution.Node>();
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {

			Node cur = pq.poll();

			if (cur.weight > dist[cur.next])
				continue;

			for (Node next : graph[cur.next]) {
				long newWeight = cur.weight + next.weight;

				if (newWeight < dist[next.next]) {
					dist[next.next] = newWeight;
					pq.add(new Node(next.next, newWeight));
				}
			}
		}
	}

}