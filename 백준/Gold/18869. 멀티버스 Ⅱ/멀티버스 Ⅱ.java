import java.io.*;
import java.util.*;

public class Main {

    static int N, M, count;
    static int[][] space;
    static int[][] idxs;
    static List<Integer>[] list; // 이런식으로도 선언이 가능하구나

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 우주 수
        M = Integer.parseInt(st.nextToken()); // 행성 수
        space = new int[N][M];
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                space[i][j] = num;
                set.add(num);
            }

            list[i] = new ArrayList<>(set);
            Collections.sort(list[i]);

        }

        idxs = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                idxs[i][j] = Collections.binarySearch(list[i], space[i][j]);
            }
        }

        int count =0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Arrays.equals(idxs[i], idxs[j])) { // 자신 뺴고 뒤에리스트랑 비교해서 있으면 ++
                    count++;
                }
            }
        }

        System.out.println(count);


    }


}
