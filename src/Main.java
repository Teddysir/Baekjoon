import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 글자를 입력받는애
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 장수
        int M = Integer.parseInt(st.nextToken()); // 합

        int[] arr = new int[N];

        for(int i = 0 ; i< N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }
}