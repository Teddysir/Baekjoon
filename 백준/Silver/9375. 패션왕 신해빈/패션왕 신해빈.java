import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < N; j++) {
            HashMap<String, Integer> nameAndKind = new HashMap<>();
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String clothName = st.nextToken();
                String kind = st.nextToken();

                if (nameAndKind.containsKey(kind)) {
                    nameAndKind.put(kind, nameAndKind.get(kind) + 1);
                } else {
                    nameAndKind.put(kind, 1);
                }

            }
            int answer = 1;

            for (int val : nameAndKind.values()) {
                answer *= (val+1);
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);

    }

}

