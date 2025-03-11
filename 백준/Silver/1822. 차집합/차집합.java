import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {

    static TreeSet<Integer> arr;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken())); 
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr.remove(num);
        }

        for (Integer integer : arr) {
            sb.append(integer).append(" ");
        }

        System.out.println(arr.size());
        System.out.println(sb);

    }


}
