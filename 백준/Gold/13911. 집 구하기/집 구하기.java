import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int to;
		long weight;

		Node(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	static StringTokenizer st;
	static int V, E, M, x, S, y;
	static int home;
	static long dist_home;
	static List<Node>[] graph;
	static long[] distStar, distMac;
	static PriorityQueue<Node> macPQ = new PriorityQueue<Main.Node>();
	static PriorityQueue<Node> starPQ = new PriorityQueue<Main.Node>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		distStar = new long[V + 1];
		distMac = new long[V + 1];
		graph = new ArrayList[V + 1];
		home = Integer.MAX_VALUE;
		dist_home = Long.MAX_VALUE;

		Arrays.fill(distStar, Long.MAX_VALUE);
		Arrays.fill(distMac, Long.MAX_VALUE);

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<Main.Node>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int mac = Integer.parseInt(st.nextToken());
			macPQ.add(new Node(mac, 0));
			distMac[mac] = 0;

		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			int star = Integer.parseInt(st.nextToken());
			starPQ.add(new Node(star, 0));
			distStar[star] = 0;
		}

		djikstar_star();
		djikstar_mac();

		for (int i = 1; i <= V; i++) {
			if (distMac[i] <= x && distStar[i] <= y) {
				if (distMac[i] != 0 && distStar[i] != 0) {
					if (distMac[i] + distStar[i] < dist_home) {
						dist_home = distMac[i] + distStar[i];
					}
				}
			}
		}

		if (dist_home == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dist_home);
		}
	}

	static void djikstar_star() {

		while (!starPQ.isEmpty()) {
			Node cur = starPQ.poll();

			if (cur.weight > distStar[cur.to]) {
				continue;
			}

			for (Node nextNode : graph[cur.to]) {
				long newWeight = cur.weight + nextNode.weight;

				if (newWeight < distStar[nextNode.to]) {
					distStar[nextNode.to] = newWeight;
					starPQ.add(new Node(nextNode.to, newWeight));
				}
			}
		}

	}

	static void djikstar_mac() {
		while (!macPQ.isEmpty()) {
			Node cur = macPQ.poll();

			if (cur.weight > distMac[cur.to]) {
				continue;
			}

			for (Node nextNode : graph[cur.to]) {
				long newWeight = cur.weight + nextNode.weight;

				if (newWeight < distMac[nextNode.to]) {
					distMac[nextNode.to] = newWeight;
					macPQ.add(new Node(nextNode.to, newWeight));
				}
			}
		}
	}

}
