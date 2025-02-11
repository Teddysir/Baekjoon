import java.io.*;
import java.util.*;

public class Main {

    public static Integer[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Integer[N + 1];

        arr[0] = 1;
        arr[1] = 1;

        System.out.println(solution(N));
    }

    static int solution(int N) {
        if (arr[N] == null) {
            arr[N] = (solution(N - 2) * 2 + solution(N - 1)) % 10007;
        }
        return arr[N];
    }


}

