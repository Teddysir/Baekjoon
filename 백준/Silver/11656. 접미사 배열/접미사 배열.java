import java.io.*;
import java.util.*;

public class Main {

    static String[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        arr = new String[s.length()];

        for(int i = 0 ; i < s.length(); i++ ){
            arr[i] = s.substring(i);
        }

        Arrays.sort(arr);

        for(int i = 0; i < s.length(); i++ ) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);


    }

}
