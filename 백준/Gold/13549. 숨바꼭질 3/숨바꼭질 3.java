
import java.io.*;
import java.util.*;

public class Main {

	static int N, K, count;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = Integer.MAX_VALUE;
		visited = new boolean[100001];

		checker(0, N);
		System.out.println(count);

	}

	static void checker(int input_count, int step) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { input_count, step });
		visited[step] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int cur_count = temp[0];
			int cur_step = temp[1];
			visited[cur_step] = true;

			if (cur_step == K) {
				count = Math.min(count, cur_count);
			}

			if (cur_step - 1 >= 0 && !visited[cur_step - 1]) {
				q.add(new int[] { cur_count + 1, cur_step - 1 });
			}

			if (cur_step + 1 <= 100000 && !visited[cur_step + 1]) {
				q.add(new int[] { cur_count + 1, cur_step + 1 });
			}

			if (cur_step * 2 <= 100000 && !visited[cur_step * 2]) {
				q.add(new int[] { cur_count, cur_step * 2 });
			}

		}

	}

}
