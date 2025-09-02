import java.io.*;
import java.util.*;

public class Solution {
    static int TC, ans;
    static int N, M, C; // map_size, honey_size, max_honey
    static int[][] map;
    static int[][] maxProfit; // DP 테이블: maxProfit[i][j] = (i,j)부터 M개 연속으로 선택했을 때 최대 이익
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        
        for (int k = 1; k <= TC; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
            maxProfit = new int[N][N - M + 1];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 1단계: 모든 가능한 구간에 대해 최대 이익을 DP로 계산
            calculateMaxProfitDP();
            
            // 2단계: 두 명의 일꾼이 선택할 수 있는 최적 조합 찾기
            ans = findOptimalCombination();
            
            sb.append("#").append(k).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    
    // DP를 이용해 각 구간별 최대 이익 계산
    static void calculateMaxProfitDP() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                // (i, j)부터 M개 연속 구간의 최대 이익 계산
                int[] honey = new int[M];
                for (int k = 0; k < M; k++) {
                    honey[k] = map[i][j + k];
                }
                maxProfit[i][j] = getMaxProfitFromArray(honey);
            }
        }
    }
    
    // 주어진 배열에서 용량 제한 C 하에서 최대 이익을 구하는 DP
    static int getMaxProfitFromArray(int[] arr) {
        int n = arr.length;
        // dp[i][w] = i번째까지 고려했을 때, 무게가 w일 때의 최대 이익
        int[][] dp = new int[n + 1][C + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= C; w++) {
                // i번째 꿀을 선택하지 않는 경우
                dp[i][w] = dp[i - 1][w];
                
                // i번째 꿀을 선택하는 경우 (무게가 충분할 때)
                if (w >= arr[i - 1]) {
                    int profit = arr[i - 1] * arr[i - 1]; // 꿀의 제곱이 이익
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - arr[i - 1]] + profit);
                }
            }
        }
        
        return dp[n][C];
    }
    
    // 두 일꾼의 최적 조합 찾기
    static int findOptimalCombination() {
        int maxTotal = 0;
        
        // 첫 번째 일꾼의 모든 가능한 선택
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 <= N - M; j1++) {
                // 두 번째 일꾼의 모든 가능한 선택
                for (int i2 = 0; i2 < N; i2++) {
                    for (int j2 = 0; j2 <= N - M; j2++) {
                        // 겹치지 않는 경우만 고려
                        if (isValidCombination(i1, j1, i2, j2)) {
                            maxTotal = Math.max(maxTotal, maxProfit[i1][j1] + maxProfit[i2][j2]);
                        }
                    }
                }
            }
        }
        
        return maxTotal;
    }
    
    // 두 구간이 겹치지 않는지 확인
    static boolean isValidCombination(int r1, int c1, int r2, int c2) {
        if (r1 != r2) {
            return true; // 다른 행이면 겹치지 않음
        }
        // 같은 행인 경우 열 구간이 겹치지 않아야 함
        return c1 + M <= c2 || c2 + M <= c1;
    }
}

/*
DP 최적화 설명:

1. 문제 분석:
   - N×N 격자에서 두 명의 일꾼이 각각 M개씩 연속된 벌통을 선택
   - 각 일꾼은 용량 C 이하로 꿀을 채취하고, 채취한 꿀의 제곱의 합이 이익
   - 두 일꾼이 선택한 구간은 겹치면 안됨

2. DP 접근법:
   - 1단계: 각 가능한 M개 연속 구간에 대해 최대 이익을 미리 계산 (냅색 DP)
   - 2단계: 겹치지 않는 두 구간의 조합 중 최대값 선택

3. 시간복잡도 개선:
   - 기존: O(N² × 2^M) - 각 구간마다 조합 계산
   - DP 후: O(N² × M × C + N⁴) - 전처리 + 조합 찾기

4. 핵심 아이디어:
   - 냅색 DP로 "무게=꿀의 양, 가치=꿀의 제곱" 문제로 변환
   - 모든 구간의 최대 이익을 미리 계산하여 중복 계산 제거
*/