import java.io.*;
import java.util.*;

public class Main {

    static int N, K, count;
    static int[] arr;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) { // 현재좌표, 도착좌표 시작부터 같으면 0
            System.out.println(0);
            return;
        }

        arr = new int[100001];
        visited = new boolean[100001];

        BFS();

    }


    static void BFS() {

        q.add(N); // 현재 좌표 넣고
        visited[N] = true; // 현재 좌표 방문
        count = 0; // 초기카운트는 0

        while (!q.isEmpty()) {
            count++; // while 돌때마다 count 증가
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                visited[temp] = true;
                if (temp - 1 == K || temp + 1 == K || temp * 2 == K) {
                    System.out.println(count);
                    return;
                }
                if (temp - 1 >= 0 && !visited[temp - 1]) {
                    visited[temp - 1] = true;
                    q.add(temp - 1);
                }
                if (temp + 1 <= 100000 && !visited[temp + 1]) {
                    visited[temp + 1] = true;
                    q.add(temp + 1);
                }
                if (temp * 2 <= 100000 && !visited[temp * 2]) {
                    visited[temp * 2] = true;
                    q.add(temp * 2);
                }
            }

        }


    }

}

