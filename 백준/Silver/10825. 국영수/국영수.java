import java.io.*;
import java.util.*;

public class Main {

    static List<Score> list = new ArrayList<>();

    static class Score {
        String name;
        int kor;
        int eng;
        int math;

        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Score(name, kor, eng, math));

        }

        Collections.sort(list, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if (o1.kor == o2.kor) {
                    if (o1.eng == o2.eng) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kor - o1.kor;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).name).append("\n");
        }
        System.out.println(sb);

    }

}
