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

    static int N, M, K;
    static long[] dist;
    static List<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static long U, C;

    public static void main(String[] args) throws IOException {

        FastReader fr = new FastReader();

        N = fr.nextInt();
        M = fr.nextInt();
        K = fr.nextInt();

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new long[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < M; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();
            int weight = fr.nextInt();

            graph[to].add(new Node(from, weight));
        }

        for (int i = 0; i < K; i++) {
            int city = fr.nextInt();
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

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int idx = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (idx >= len) {
                len = in.read(buffer);
                idx = 0;
                if (len == -1) return -1;
            }
            return buffer[idx++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= 32 && c != -1);
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}