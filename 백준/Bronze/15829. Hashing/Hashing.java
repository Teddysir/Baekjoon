import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = 31;
        int M = 1234567891;

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();


        long sum = 0;
        long res = 1;

        for (int i = 0; i < n; i++) {
            sum += (((str.charAt(i) - 96) * res) % 1234567891);
            res = (res*31)%1234567891;
        }

        System.out.println(sum);


    }

}