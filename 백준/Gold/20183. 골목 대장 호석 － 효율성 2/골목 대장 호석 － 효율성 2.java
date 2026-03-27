import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int to;
		long cost;

		public Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	static StringTokenizer st;
	static int N, M, S, E;
	static long money, maxCost, answer;
	static List<Node>[] graph;
	static long[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 교차로 수
		M = Integer.parseInt(st.nextToken()); // 골목 수
		S = Integer.parseInt(st.nextToken()); // 시작점
		E = Integer.parseInt(st.nextToken()); // 도착점
		money = Long.parseLong(st.nextToken()); // 가진

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Main.Node>();
		}
		answer = -1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long cost = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, cost));
			graph[to].add(new Node(from, cost));

			maxCost = Math.max(cost, maxCost);
		}

		long left = 0;
		long right = maxCost;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (djikstra(mid)) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(answer);

	}

	static boolean djikstra(long mid) {
		PriorityQueue<Node> pq = new PriorityQueue<Main.Node>();
		pq.add(new Node(S, 0));
		dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[S] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.cost > dist[cur.to]) {
				continue;
			}

			for (Node nextNode : graph[cur.to]) {
				
				if(nextNode.cost > mid) {
					continue;
				}
				
				long newCost = cur.cost + nextNode.cost;

				if (newCost > money) {
					continue;
				}

				if (newCost < dist[nextNode.to]) {
					dist[nextNode.to] = newCost;
					pq.add(new Node(nextNode.to, newCost));
				}
			}
		}

		if (dist[E] == Long.MAX_VALUE) {
			return false;
		} else {
			return true;
		}
	}

}
