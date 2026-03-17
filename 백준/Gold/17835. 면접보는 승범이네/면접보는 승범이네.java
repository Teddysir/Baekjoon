import java.io.*;
import java.util.*;


public class Main {

    static class Node implements Comparable<Node> {
        int from;
        long cost;

        Node(int from, long cost) {
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static StringTokenizer st;
    static int N, M, K;
    static long[] dist;
    static List<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static long U, C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new long[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[to].add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int city = Integer.parseInt(st.nextToken());
            pq.add(new Node(city, 0));
            dist[city] = 0;
        }

        djikstra();

        for (int i = 1; i <= N; i++) {
            if (dist[i] > C) {
                C = dist[i];
                U = i;
            }
        }
        System.out.println(U);
        System.out.println(C);

    }

    static void djikstra() {
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.from]) {
                continue;
            }

            for (Node nextNode : graph[cur.from]) {
                long newCost = cur.cost + nextNode.cost;

                if (newCost < dist[nextNode.from]) {
                    dist[nextNode.from] = newCost;
                    pq.add(new Node(nextNode.from, newCost));
                }
            }

        }
    }
}