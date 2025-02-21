import java.io.*;
import java.util.*;

public class Main {

    static boolean[] checked;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            checked = new boolean[N+1];
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            for(int j = 1; j <= N; j++) {
                if(!checked[j]) {
                    DFS(j);
                    count++;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    static void DFS(int N) {
        checked[N] = true;
        
        int nextNode = arr[N];
        if(!checked[nextNode]) {
            DFS(nextNode);
        }
    }


}

