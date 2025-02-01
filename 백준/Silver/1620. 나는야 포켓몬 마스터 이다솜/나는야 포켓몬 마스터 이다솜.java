import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> mp = new HashMap<>();
        HashMap<String, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String pocketMonName = br.readLine();
            mp.put(i + 1, pocketMonName);
            mp2.put(pocketMonName, i + 1);

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input.charAt(0) >= 49 && input.charAt(0) <= 57) {
                sb.append(mp.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(mp2.get(input)).append("\n");
            }
        }
        System.out.println(sb);

    }
}


