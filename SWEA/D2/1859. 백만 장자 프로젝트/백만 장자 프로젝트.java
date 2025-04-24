import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long standard = 0;
            long profit = 0;

            for (int i = N - 1; i >= 0; i--) {
                if(standard < arr[i]){
                    standard = arr[i];
                } else {
                    profit += (standard - arr[i]);
                }
            }


            sb.append("#").append(test_case).append(" ").append(profit).append("\n");

        }

        System.out.println(sb);
    }


}