import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int vertical = Integer.parseInt(st.nextToken());

        int cnt = (vertical-down) / (up-down); // 4/1 = 4
        if((vertical-down) % (up-down) != 0)
            cnt++;

        System.out.println(cnt);

    }
}