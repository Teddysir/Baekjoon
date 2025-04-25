import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {

            int testcase = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < 1000; i++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int value = Integer.MIN_VALUE;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() > value) {
                    value = entry.getValue();
                }
            }

            List<Integer> list = new ArrayList<>();

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == value) {
                    list.add(entry.getKey());
                }
            }

            sb.append("#").append(testcase).append(" ").append(list.get(list.size()-1)).append("\n");

        }

        System.out.println(sb);
    }


}