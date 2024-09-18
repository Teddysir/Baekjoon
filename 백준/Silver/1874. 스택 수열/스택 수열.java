import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int val = 0;

        for(int i = 0; i< N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > val) {
                for (int j = val + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                val = num;
            } else if(stack.peek() != num){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);

    }

}