import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if ((arr[i][1] == 1 || arr[1][i] == 1)) {
				visited[i] = true;
				you_are_my_fri_fri(i);
			}

		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				ans++;
		}
		if (ans == 0) {
			System.out.println(0);
		} else {
			System.out.println(ans - 1);
		}

	}

	static void you_are_my_fri_fri(int x) {

		for (int i = 1; i <= N; i++) {
			if ((arr[x][i] == 1 || arr[i][x] == 1)) {
				visited[i] = true;
			}
		}

	}

}
