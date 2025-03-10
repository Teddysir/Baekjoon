import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        for(int i = 0 ; i < N; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String input1 = st.nextToken();
            String input2 = st.nextToken();

            map.put(input1, input2);
        }


        List<String> answer = new ArrayList<>();

        for(Map.Entry<String, String> entry : map.entrySet()) {
            if("enter".equals(entry.getValue())) {
                answer.add(entry.getKey());
            }
        }

        Collections.sort(answer);

        for(int i = answer.size() -1 ; i >= 0;i-- ){
            System.out.println(answer.get(i));
        }





        // 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.


    }


}
