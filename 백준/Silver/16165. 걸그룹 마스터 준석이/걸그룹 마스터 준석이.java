import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int M = Integer.parseInt(st.nextToken()); // 맞춰야하는 문제 수

        for (int i = 0; i < N; i++) {
            String girlGroup = br.readLine();
            int members = Integer.parseInt(br.readLine());

            for (int j = 0; j < members; j++) {
                String memberName = br.readLine();
                map.put(memberName, girlGroup);
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int qType = Integer.parseInt(br.readLine());

            if (qType == 1) {
                sb.append(map.get(input)).append("\n");
            } else {
                List<String> newList = new ArrayList<>();
                for(Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(input)) {
                        newList.add(entry.getKey());
                    }
                    Collections.sort(newList);
                }
                for(int j = 0 ; j < newList.size(); j++ ){
                    sb.append(newList.get(j)).append("\n");
                }

            }
        }

        System.out.println(sb);


    }

}
