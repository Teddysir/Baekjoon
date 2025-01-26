import java.io.*;
import java.util.*;

public class Main {

    public static Set<Integer> S = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 연산 횟수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int num = -1;
            if (method.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                add(num);
            } else if (method.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                remove(num);
            } else if (method.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                sb.append(check(num)).append("\n");
            } else if (method.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                toggle(num);
            } else if (method.equals("all")) {
                all();
            } else if (method.equals("empty")) {
                empty();
            }
        }

        System.out.println(sb);

    }

    public static void add(int T) {
        S.add(T);
    }

    public static void remove(int T) {
        S.remove(T);
    }

    public static int check(int T) {
        if (S.contains(T)) {
            return 1;
        }
        return 0;
    }

    public static void toggle(int T) {
        if (S.contains(T)) {
            S.remove(T);
        } else {
            S.add(T);
        }

    }

    public static void all() {
        S = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            S.add(i);
        }
    }

    public static void empty() {
        S.clear();
    }


}

