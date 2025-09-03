import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from, to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parent[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        Collections.sort(edges); // 간선 가중치 오름차순 정렬

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        int count = 0;
        int total = 0;
        int maxEdge = 0;

        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                total += e.weight;
                maxEdge = e.weight;
                count++;
                if (count == V - 1) break;
            }
        }

        System.out.println(total - maxEdge); // 가장 큰 간선 제거
    }
}
