import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< N; i++ ){
            q.add(i+1);
        }
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            for(int i =0; i < K-1; i++ ) {
                int num = q.poll();
                q.offer(num);
            }
            if(q.size() == 1){
                sb.append(q.poll());
            } else {
                sb.append(q.poll()).append(", ");
            }
        }

        System.out.println("<"+ sb + ">");

    }
}

