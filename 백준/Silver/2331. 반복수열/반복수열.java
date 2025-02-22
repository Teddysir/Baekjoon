import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken()); // 입력받은 수
        int square = Integer.parseInt(st.nextToken()); //

        arr = new ArrayList<>();
        arr.add(num);

        while (true) {
            int temp = arr.get(arr.size() - 1);
            int result = nextNode(temp, square);

            if(arr.contains(result)) {
                System.out.println(arr.indexOf(result));
                break;
            }

            arr.add(result);
        }

    }

    static int nextNode(int num, int square) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, square);
            num /= 10;
        }
        return sum;
    }

}
