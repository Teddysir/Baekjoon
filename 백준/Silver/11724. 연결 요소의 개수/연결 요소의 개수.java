import java.io.*;
import java.util.*;

public class Main {

    static int node;
    static int line;
    static int[][] arr;
    static boolean[] check;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A][B] = arr[B][A] = 1;

        }
        count = 0;

        for(int i = 1; i <= node; i++ ){
            if(check[i] == false) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void DFS(int start) {
        if(check[start] == true) {
            return;
        } else {
            check[start] = true;
            for(int i = 1; i<= node; i++ ){
                if(arr[start][i] == 1) {
                    DFS(i);
                }
            }
        }

    }

}

