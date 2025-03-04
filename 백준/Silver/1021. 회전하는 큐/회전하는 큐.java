import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    static int count = 0;
    static LinkedList<Integer> deque = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            solution(num);
        }

        System.out.println(count);

    }

    static void solution(int num) {
        if (deque.size() / 2 < deque.indexOf(num)) {
            while (deque.getFirst() != num) {
                int lastNode = deque.pollLast();
                deque.offerFirst(lastNode);
                count++;
            }
        } else {
            while (deque.getFirst() != num) {
                int firstNode = deque.pollFirst();
                deque.offerLast(firstNode);
                count++;
            }
        }
        deque.pollFirst();
    }


}
