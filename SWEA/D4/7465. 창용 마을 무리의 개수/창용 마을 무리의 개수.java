import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N, M;
	static int[] parent;
	static Set<Integer> set;

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

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int tempX = Integer.parseInt(st.nextToken());
				int tempY = Integer.parseInt(st.nextToken());

				union(tempX, tempY);

			}
			set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				set.add(find(i));
			}

			sb.append("#").append(k).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		if (nx != ny) {
			parent[ny] = nx;
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
}
