import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stackInt = new Stack<>();

        for(int i =0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stackInt.pop();
            } else {
                stackInt.push(n);
            }
        }
        int count = 0;

        for(int o : stackInt){
            count += o;
        }
        System.out.println(count);
    }


}

