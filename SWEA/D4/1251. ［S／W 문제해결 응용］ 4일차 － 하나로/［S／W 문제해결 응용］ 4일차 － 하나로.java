import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N;
	static double ans;
	static double E;

	static int[] list_x, list_y;
	static boolean[] visited;

	static List<Edge>[] adjList;
	static Node[] nodeList;

	static class Node {
		long x, y;

		Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int to;
		double weight;

		Edge(int to, double weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {
			N = Integer.parseInt(br.readLine());

			/// 배열 선언부
			ans = 0;
			list_x = new int[N];
			list_y = new int[N];
			visited = new boolean[N + 1];
			adjList = new ArrayList[N];
			nodeList = new Node[N];
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<Edge>();
			}
//			Arrays.fill(visited, Integer.MAX_VALUE); // 음? 
			///

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list_x[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list_y[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				int x = list_x[i];
				int y = list_y[i];

				nodeList[i] = new Node(x, y);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double dist = euclid(nodeList[i].x, nodeList[j].x, nodeList[i].y, nodeList[j].y);
					adjList[i].add(new Edge(j, dist));
					adjList[j].add(new Edge(i, dist));
				}
			}
			prim(1);

			E = Double.parseDouble(br.readLine());

			sb.append("#").append(k).append(" ").append(Math.round(ans * E)).append("\n");
		}
		System.out.println(sb);
	}

	static void prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {

			Edge e = pq.poll();
			int to = e.to;
			double weight = e.weight;
			if (visited[e.to])
				continue;

			visited[to] = true;
			ans += weight;

			for (Edge edge : adjList[to]) {
				if (!visited[edge.to]) {
					pq.add(new Edge(edge.to, edge.weight));
				}
			}
		}

	}

	static double euclid(long x1, long x2, long y1, long y2) {
		long nx = x2 - x1;
		long ny = y2 - y1;
		return (nx * nx + ny * ny);
	}

}
