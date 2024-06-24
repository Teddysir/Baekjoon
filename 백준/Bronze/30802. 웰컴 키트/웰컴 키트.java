import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.parseLong(br.readLine());
        int[] arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        Long T = Long.parseLong(st.nextToken());
        Long P = Long.parseLong(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i]/T;
            if(arr[i] % T > 0){
                cnt += 1;
            }
        }
        System.out.println(cnt);
        System.out.println((N / P) + " " + (N % P));


    }
}