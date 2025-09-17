import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    // static int ans; // 더 이상 필요 없으므로 제거

    static int[] dr = { 0, 1, 1 }; // 우, 대각, 아래
    static int[] dc = { 1, 1, 0 };

    static long[][][] dp; // 경로의 수가 int 범위를 넘을 수 있으므로 long으로 변경

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1); // -1로 초기화하여 아직 계산 안 됐음을 표시
            }
        }

        // dfs 함수가 경로의 수를 반환하므로, 결과를 받아서 출력
        long result = dfs(1, 2, 0);
        System.out.println(result);
    }

    // (r, c)에 dir 방향으로 있을 때, 여기서부터 도착점까지 갈 수 있는 경로의 수를 반환
    static long dfs(int r, int c, int dir) {

        // ⭐ 핵심 1: 메모이제이션 확인
        // 이미 현재 상태에서 도착점까지 가는 경로의 수를 계산했다면 즉시 반환
        if (dp[r][c][dir] != -1) {
            return dp[r][c][dir];
        }
        
        // 도착점에 도달하면 1개의 경로를 찾은 것
        if (r == N && c == N) {
            return 1;
        }

        long count = 0; // 현재 상태에서 시작되는 경로의 수를 누적할 변수

        if (dir == 0) { // 현재 방향이 우
            // 다음 이동: 우, 대각
            count += checker(r + dr[0], c + dc[0], 0); 
            count += checker(r + dr[1], c + dc[1], 1);
        } else if (dir == 1) { // 현재 방향이 대각
            // 다음 이동: 우, 대각, 아래
            count += checker(r + dr[0], c + dc[0], 0);
            count += checker(r + dr[1], c + dc[1], 1);
            count += checker(r + dr[2], c + dc[2], 2);
        } else { // 현재 방향이 아래
            // 다음 이동: 대각, 아래
            count += checker(r + dr[1], c + dc[1], 1);
            count += checker(r + dr[2], c + dc[2], 2);
        }
        
        // ⭐ 핵심 2: 결과 기록 및 반환
        // 계산된 경로의 수를 dp 배열에 저장하고 반환
        return dp[r][c][dir] = count;
    }

    // (nr, nc)로 dir 방향으로 이동하는 것이 유효한지 검사하고,
    // 유효하다면 그 지점부터 시작되는 경로의 수를 반환
    static long checker(int nr, int nc, int dir) {

        // 맵을 벗어나거나 벽을 만나면 경로의 수 0을 반환
        if (nr > N || nc > N || map[nr][nc] == 1) {
            return 0;
        }

        // 대각선으로 이동 시 추가 검사
        if (dir == 1) {
            if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
                return 0; // 경로의 수 0을 반환
            }
        }

        // 유효한 이동이라면, 그 지점에서부터 다시 dfs 탐색 시작
        return dfs(nr, nc, dir);
    }
}