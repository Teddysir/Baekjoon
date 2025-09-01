import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static int[] parent;
	static int ans, check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		boolean flag = false;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				// 만약 union이 실패했다면?
				if(!flag) {
					flag = true; // 일단 플래그세워주고
					check = ans;					
				}
			}
			ans++;

		}

		if (flag) {
			System.out.println(check+1);
		} else {
			if (ans == E) {
				System.out.println(0);
			} else {
				System.out.println(ans);
			}
		}

	}

	static boolean union(int x, int y) {
		int nx = find(x);
		int ny = find(y);

		if (nx == ny) {
			return false;
		}

		if (nx != ny) {
			if (nx > ny) {
				parent[nx] = ny;
			} else {
				parent[ny] = nx;
			}
		}
		return true;

	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);

	}
}
