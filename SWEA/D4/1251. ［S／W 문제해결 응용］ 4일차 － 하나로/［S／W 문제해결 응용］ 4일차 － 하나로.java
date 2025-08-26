import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N;
	static double ans;
	static long[] list_x;
	static long[] list_y;
	static double E; 
	static int[] parent;

	static Node[] nodeList;
	static List<Edge> edgeList;

	static class Node {
		long x, y;

		Node(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int x, y;
		double weight;

		Edge(int x, int y, double weight) {
			this.x = x;
			this.y = y;
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

			list_x = new long[N];
			list_y = new long[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list_x[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list_y[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());

			nodeList = new Node[N];
			for (int i = 0; i < N; i++) {
				nodeList[i] = new Node(list_x[i], list_y[i]); // 좌표에대한 노드 만들고
			}

			edgeList = new ArrayList<Edge>();
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					double dist = euclid(nodeList[i], nodeList[j]);
					edgeList.add(new Edge(i, j, dist));
				}
			}

			Collections.sort(edgeList);

			parent = new int[N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
			ans = 0;

			for (Edge edge : edgeList) {
				if (union(edge.x, edge.y)) {
					ans += edge.weight; // 합쳤으면 정답에 가중치 추가
					count++;
				}
				if (count == N - 1) {
					break;
				}
			}

			sb.append("#").append(k).append(" ").append(Math.round(ans)).append("\n");
		}
		System.out.println(sb);
	}

	static boolean union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		if (nx != ny) {
			if(nx < ny) {
				parent[ny] = nx;				
			} else {
				parent[nx] = ny;
			}
			return true;
		}
		return false;
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static double euclid(Node n1, Node n2) {

		long nx = n1.x - n2.x;
		long ny = n1.y - n2.y;
		return (((nx * nx) + (ny * ny)) * E);
	}

}
