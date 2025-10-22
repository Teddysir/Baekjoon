import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = { 0, -1, -1, 0, 1, 1, 1, 0, -1 }; // 무방향, 위, 왼대, 왼, 왼아, 아, 아오, 오, 오위
    static int[] dc = { 0, 0, -1, -1, -1, 0, 1, 1, 1 }; // 0 무방향 1 ~ 8 ..
    static int ans = 0;

    static class Fish {
        int num, vector;

        Fish(int num, int vector) {
            this.num = num;
            this.vector = vector;
        }

        void setter(int input_num, int input_vector) {
            this.num = input_num;
            this.vector = input_vector;
        }

        void set_vector(int input_vector) {
            this.vector = input_vector;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Fish[][] origin_map = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int fish_num = Integer.parseInt(st.nextToken());
                int vector = Integer.parseInt(st.nextToken());

                origin_map[i][j] = new Fish(fish_num, vector);
            }
        }

        // 상어가 (0,0) 물고기를 먹고 시작
        int first_eat = origin_map[0][0].num;
        int shark_dir = origin_map[0][0].vector;
        origin_map[0][0] = new Fish(20, shark_dir); // 상어 표시

        boolean[] death = new boolean[17];
        death[first_eat] = true;

        start(origin_map, death, 0, 0, first_eat);

        System.out.println(ans);
    }

    static void start(Fish[][] input_map, boolean[] death, int shark_r, int shark_c, int sum) {
        // 현재 상태 저장 (깊은 복사)
        Fish[][] copied_map = copy_map(input_map);
        boolean[] copied_death = death.clone();

        // 물고기 이동
        fish_swap(copied_map, copied_death);

        // 상어가 이동할 수 있는 모든 경우 탐색
        int shark_vector = copied_map[shark_r][shark_c].vector;
        boolean can_move = false;

        for (int i = 1; i <= 3; i++) {
            int nr = shark_r + dr[shark_vector] * i;
            int nc = shark_c + dc[shark_vector] * i;

            if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) break;

            if (copied_map[nr][nc] != null && copied_map[nr][nc].num != 20) {
                can_move = true;

                // 상어가 해당 물고기를 먹음
                int eat_fish = copied_map[nr][nc].num;
                int new_shark_dir = copied_map[nr][nc].vector;

                Fish[][] next_map = copy_map(copied_map);
                boolean[] next_death = copied_death.clone();

                next_map[shark_r][shark_c] = null; // 상어 원래 위치 비우기
                next_map[nr][nc] = new Fish(20, new_shark_dir); // 새 위치에 상어
                next_death[eat_fish] = true;

                start(next_map, next_death, nr, nc, sum + eat_fish);
            }
        }

        // 더 이상 이동할 수 없으면 최댓값 갱신
        if (!can_move) {
            ans = Math.max(ans, sum);
        }
    }

    static void fish_swap(Fish[][] input_map, boolean[] death) {
        for (int i = 1; i <= 16; i++) {
            if (!death[i]) {
                // 물고기 i를 찾기
                out: for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (input_map[j][k] != null && input_map[j][k].num == i) {
                            int vector = input_map[j][k].vector;
                            int vector_find_count = 0;

                            while (vector_find_count < 8) {
                                int nr = j + dr[vector];
                                int nc = k + dc[vector];

                                // 범위 체크
                                if (nr < 0 || nc < 0 || nr >= 4 || nc >= 4) {
                                    vector_find_count++;
                                    vector = (vector % 8) + 1;
                                    continue;
                                }

                                // 상어가 있는 곳은 이동 불가
                                if (input_map[nr][nc] != null && input_map[nr][nc].num == 20) {
                                    vector_find_count++;
                                    vector = (vector % 8) + 1;
                                    continue;
                                }

                                // 빈 칸으로 이동
                                if (input_map[nr][nc] == null) {
                                    input_map[nr][nc] = input_map[j][k];
                                    input_map[nr][nc].set_vector(vector);
                                    input_map[j][k] = null;
                                    break out;
                                }

                                // 다른 물고기와 스왑
                                if (input_map[nr][nc] != null) {
                                    Fish temp = input_map[nr][nc];
                                    input_map[nr][nc] = input_map[j][k];
                                    input_map[j][k] = temp;
                                    input_map[nr][nc].set_vector(vector);
                                    break out;
                                }
                            }

                            // 8방향 모두 막혔으면 제자리
                            break out;
                        }
                    }
                }
            }
        }
    }

    // 맵 깊은 복사
    static Fish[][] copy_map(Fish[][] input_map) {
        Fish[][] new_map = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (input_map[i][j] != null) {
                    new_map[i][j] = new Fish(input_map[i][j].num, input_map[i][j].vector);
                }
            }
        }
        return new_map;
    }
}