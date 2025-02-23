import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static final int INF = 1000000;

    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];


        for (int i = 1; i <= N; i++) { // 모든 간선끼리 이동 값을 INF로 지정해주고
            for (int j = 1; j <= N; j++) {
                graph[i][j] = INF;

                if (i == j) { // 자기 자신으로 이동하는건 비용이 0이니 0으로 초기화해주고
                    graph[i][j] = 0;
                }

            }
        }

        for (int i = 0; i < M; i++) { // 해당 입력받은 간선끼리는 값이 1이니까 1로 초기화해주고
            st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1][num2] = graph[num2][num1] = 1;
        }


        for (int i = 1; i <= N; i++) { // 거쳐가는 노드
            for (int j = 1; j <= N; j++) { // 출발 노드
                for (int k = 1; k <= N; k++) { // 도착 노드
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += graph[i][j];
            }

            if(res > total) {
                res = total;
                idx = i;
            }
        }

        System.out.println(idx);


    }


}
