import java.io.*;
import java.util.*;

public class Main {

    static Stack<Node> stack = new Stack<Node>();
    static int[] arr;

    static class Node {
        int idx;
        int height;

        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().height >= arr[i]) {
                    sb.append(stack.peek().idx + 1).append(" ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }

            stack.push(new Node(i, arr[i]));

        }

        System.out.println(sb);


    }

}
