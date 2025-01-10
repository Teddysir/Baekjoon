import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> cantListen = new HashSet<>();

        for (int i = 0; i < N; i++) {
            cantListen.add(br.readLine());
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (cantListen.contains(str)) {
                result.add(str);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

}

