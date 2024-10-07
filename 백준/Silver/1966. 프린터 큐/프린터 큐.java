import java.io.*;
import java.util.*;

public class Main {

    static LinkedList<int[]> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        while(K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();

            int num = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < num; i++ ){
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            sb.append(answer(point)).append('\n');

        }
        System.out.println(sb);


        }

        public static int answer(int point) {
            int count = 0;

            while (!queue.isEmpty()) {

                int[] first = queue.poll();
                boolean isMax = true;

                for(int i = 0 ; i < queue.size(); i++ ) {
                    if (first[1] < queue.get(i)[1]) {

                        queue.offer(first);
                        for(int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax) {
                    continue;
                }
                count++;
                if(first[0] == point) {
                    break;
                }
            }
            return count;
        }



}