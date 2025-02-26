import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] =  answer[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;


        for(int i = 0 ; i < N; i++ ){
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], count++);
            }
        }


        StringBuilder sb= new StringBuilder();
        for(int i = 0; i < N; i++ ){
            sb.append(map.get(answer[i])).append(" ");
        }

        System.out.println(sb);

    }


}
