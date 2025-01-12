import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String addr = input[0];
            String password = input[1];

            hashMap.put(addr, password);

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            String value = hashMap.get(key);
            if(value != null) {
                sb.append(value).append("\n");
            }
        }

        System.out.println(sb);

    }


}

