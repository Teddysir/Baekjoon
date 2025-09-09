
import java.io.*;
import java.util.*;

public class Main {

	static int problem, good, ans;
	static int[] inDegree;

	static PriorityQueue<Integer>[] pq;
	static List<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		problem = Integer.parseInt(st.nextToken());
		good = Integer.parseInt(st.nextToken());
		inDegree = new int[problem + 1];

		pq = new PriorityQueue[problem + 1];

		for (int i = 0; i <= problem; i++) {
			pq[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		for (int i = 0; i < good; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			pq[a].add(b);

			inDegree[b]++;
		}

		topology();

		for (int i = 0; i < problem; i++) {
			sb.append(answer.get(i)).append(" ");
		}
		System.out.println(sb);

	}

	static void topology() {
		PriorityQueue<Integer> temp = new PriorityQueue<>();

		for (int i = 1; i <= problem; i++) {
			if (inDegree[i] == 0) {
				temp.add(i);
			}
		}

		while (!temp.isEmpty()) {

			int poll = temp.poll();

			answer.add(poll);

			for (int next : pq[poll]) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					temp.add(next);
				}
			}

		}
	}
}