import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static int[][] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) { // 거쳐가는 노드
            for (int j = 0; j < N; j++) { // 출발 노드
                if(graph[j][i] == 0 ){
                    continue;
                }
                answer[j][i] = 1; // 일단 답란 채워주고
                for (int k = 0; k < N; k++) { // 도착 노드
                    if(graph[i][k] == 0 ){
                        continue;
                    }
                    graph[j][k] = 1;
                    answer[j][k] = 1;
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


}
