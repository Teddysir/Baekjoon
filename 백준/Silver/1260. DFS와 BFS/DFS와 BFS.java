import java.io.*;
import java.util.*;

public class Main {

    static boolean[] check;
    static int[][] arr;
    static int count; // 노드 갯수랑 같으면 정지시킬 카운트
    static int node;
    static int line;
    static int start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            arr[num1][num2] = arr[num2][num1] = 1;
        }

        DFS(start);
        System.out.println();

        check = new boolean[node + 1];
        BFS(start);
    }

    static void BFS(int start) {
        q.offer(start); // start node 넣기
        check[start] = true; // 방문 체크

        System.out.print(start + " "); // 출력

        while (!q.isEmpty()) {
            start = q.poll();

            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.offer(i);
                    check[i] = true;
                    System.out.print(i + " ");
                }
            }
        }

    }

    static void DFS(int start) {
        check[start] = true;
        System.out.print(start + " ");

        if (count == node) {
            return;
        }

        count++;

        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                DFS(i);
            }
        }
    }
}

