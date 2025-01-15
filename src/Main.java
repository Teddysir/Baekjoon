import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int count = 0;
    public static int[][] node;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        node = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            node[K][J] = node[J][K] = 1;
        }

        dfs(1);
        System.out.println(count - 1);
    }

    static void dfs(int K) {
        visited[K] = true;
        count += 1;

        for (int i = 1; i <= N; i++) {
            if (node[K][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}

