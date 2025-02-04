import java.io.*;
import java.util.*;

public class Main {

    public static PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());

            if(input == 0 ) {
                if (queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.add(input);
            }
        }

        System.out.println(sb);
    }

}


