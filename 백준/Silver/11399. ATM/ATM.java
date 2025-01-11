import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        Collections.sort(list);

        int count = 0 ;
        int tmp = 0;

        for(int i = 0; i < list.size(); i++ ){
            tmp += list.get(i);
            count += tmp;
        }

        System.out.println(count);



    }


}

