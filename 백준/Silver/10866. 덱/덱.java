import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            if (input.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
            } else if (input.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
            } else if (input.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getFirst()).append("\n");
                }

            } else if (input.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.getLast()).append("\n");
                }

            } else if (input.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (input.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (input.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollFirst()).append("\n");
                }
            } else if (input.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deque.pollLast()).append("\n");
                }
            }


        }
        System.out.println(sb);


    }


}
