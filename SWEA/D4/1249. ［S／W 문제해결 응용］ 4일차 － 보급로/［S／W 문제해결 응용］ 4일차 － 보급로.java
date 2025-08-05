import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N;
	static int[][] map;
	static int[][] dist;
	static int ans;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Node implements Comparable<Node> {
		int x, y, cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - 48;
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			ans = solution();

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static int solution() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		dist[0][0] = map[0][0]; // -> 0으로 초기
		pq.add(new Node(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Node temp = pq.poll();

			int curX = temp.x;
			int curY = temp.y;
			int curCost = temp.cost;

			if (curCost > dist[curX][curY]) { // 들어온 비용이 원래있던 비용보다 크면비교할 필요 없다 - 기저조건?
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {

					int newCost = dist[curX][curY] + map[nx][ny];
					if (newCost < dist[nx][ny]) {
						dist[nx][ny] = newCost;
						pq.add(new Node(nx, ny, newCost));
					}

				}
			}
		}

		return dist[N - 1][N - 1];
	}

}
