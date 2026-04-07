import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());

				pq.offer(num);

				if (pq.size() > N) {
					pq.poll();
				}
			}
		}


		System.out.println(pq.poll());

	}

}