import java.io.*;
import java.util.*;

public class Main {

    public static Integer[][] arr = new Integer[41][2]; //  0- 40 / 0, 1

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            solution(num);
            sb.append(arr[num][0]).append(" ").append(arr[num][1]).append("\n");
        }
        System.out.println(sb);

    }

    public static Integer[] solution(int N) {

        if (arr[N][0] == null || arr[N][1] == null) {
            arr[N][0] = solution(N - 1)[0] + solution(N - 2)[0];
            arr[N][1] = solution(N - 1)[1] + solution(N - 2)[1];
        }

        return arr[N];
    }

}


