
import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static long ans;
	static long max;

	static boolean[] visited;
	static List<Home>[] adjList;

	static class Home implements Comparable<Home> {
		int to;
		long weight;

		Home(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Home o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new boolean[V + 1];
		adjList = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<Home>();
		}

		int start = -1;
		long small_weight = Integer.MAX_VALUE;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());

			if (weight < small_weight) {
				small_weight = weight;
				start = from;
			}

			adjList[from].add(new Home(to, weight));
			adjList[to].add(new Home(from, weight));

		}
//		System.out.println(start);

		prim(start); // 1부터 시작하기보단, 가중치가 가장 낮은애들먼저 해야하는듯?

//		System.out.println(Arrays.toString(visited));
		System.out.println(ans - max);

	}

	static void prim(int start) {
		PriorityQueue<Home> pq = new PriorityQueue<>();
		pq.add(new Home(start, 0));

		while (!pq.isEmpty()) {

			Home h = pq.poll();

			if (visited[h.to])
				continue;

//			System.out.println(h.to + " " + h.weight + " 이렇게 더합니다 ");

//			System.out.println(h.to + " : " + h.weight + " 이거부터 더합니다.");
			ans += h.weight;
//			count++;
			visited[h.to] = true;
			if (h.weight > max) {
				max = h.weight;
			}

			for (Home home : adjList[h.to]) {
				if (!visited[home.to]) {
//					System.out.println(home.to + ": 방문");
					pq.add(new Home(home.to, home.weight));
				}
			}
		}

	}

}
