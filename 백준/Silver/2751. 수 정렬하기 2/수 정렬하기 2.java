import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        for (int c : arr) {
            sb.append(c).append('\n');
        }
        System.out.println(sb);

    }
}