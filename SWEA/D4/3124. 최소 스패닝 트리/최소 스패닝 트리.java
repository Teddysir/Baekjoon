import java.io.*;
import java.util.*;

public class Solution {

	static int TC, V, E;
	static long ans;

	static int from, to;
	static long weight;
	static int[] parent;
	static List<Edge> edgeList;

	static int count;

	static class Edge implements Comparable<Edge> {
		int x, y;
		long weight;

		Edge(int x, int y, long weight) {
			this.x = x;
			this.y = y;
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

			V = Integer.parseInt(st.nextToken()); // 노드
			E = Integer.parseInt(st.nextToken()); // 간선

			/// 배열 선언부
			parent = new int[V + 1]; // 정점의 좌표는 1부터 시작이기때문에 배열은 1~V까지 ,
			for (int i = 1; i < V + 1; i++) {
				parent[i] = i;
			}
			edgeList = new ArrayList<Edge>();
			ans = 0;
			count = 0;
			///

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken()); // 시작
				to = Integer.parseInt(st.nextToken()); /// 도착
				weight = Long.parseLong(st.nextToken()); // 가중치 //-> 음수도가능
				edgeList.add(new Edge(from, to, weight));
			}

			Collections.sort(edgeList);

			for (Edge edge : edgeList) {
				if (union(edge.x, edge.y)) {
					ans += edge.weight;
					count++;
				}
				if (count == V - 1) {
					break;
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static boolean union(int x, int y) {

		int nx = find(x);
		int ny = find(y);

		if (nx != ny) {
			if (nx > ny) {
				parent[nx] = ny;
			} else {
				parent[ny] = nx;
			}
			return true; // 유니온 성공
		}
		return false; // 유니온 실패

	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}
