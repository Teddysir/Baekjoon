import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N, M;
	static int[] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			// 0 은 합집합
			// 1은 포함되어있는지?

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			sb.append("#").append(k).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int game = Integer.parseInt(st.nextToken());
				int tempX = Integer.parseInt(st.nextToken());
				int tempY = Integer.parseInt(st.nextToken());

				if (game == 0) {
					union(tempX, tempY);
				} else {
					if (find(tempX) == find(tempY)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}

			sb.append("\n");

		}
		System.out.println(sb);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y] = x;
		}
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}

	}
}
