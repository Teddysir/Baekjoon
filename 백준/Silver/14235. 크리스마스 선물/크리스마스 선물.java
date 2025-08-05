import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int input = Integer.parseInt(st.nextToken());
			if (input == 0) {
				if (pq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(-pq.poll()).append("\n");
				}
			} else {
				for (int j = 0; j < input; j++) {
					pq.add(-Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}

}
