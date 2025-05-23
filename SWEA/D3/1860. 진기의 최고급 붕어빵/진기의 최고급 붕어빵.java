import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static int T, N, M, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 사람 수
            M = Integer.parseInt(st.nextToken()); // 초당
            K = Integer.parseInt(st.nextToken()); // 만드는 붕어빵

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int breadCount = 0;
            int count = 0;
            int idx = 0;
            boolean check = false;
            
            if(arr[0] == 0){
                check = true;
            }
            
            
            for (int i = 1; i <= arr[N-1]; i++) { // 1, 2, 3, 4.. ..
                count++;

                if (i % M == 0) {
                    breadCount += K; // 2, 4 일때마다 2씩 더함
                }

                if (arr[idx] == count) {
                    if (breadCount > 0) {
                        breadCount--;
                        idx++;
                    } else {
                        check = true;
                    }
                }

//                if (idx > N) {
//                    break;
//                }

            }

            if (!check) {
                sb.append("#").append(test_case).append(" ").append("Possible").append("\n");
            } else {
                sb.append("#").append(test_case).append(" ").append("Impossible").append("\n");

            }


        }
        System.out.println(sb);

    }


}


