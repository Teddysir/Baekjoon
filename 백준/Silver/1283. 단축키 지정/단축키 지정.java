import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();
    static boolean[] is_used = new boolean[26]; // a = 97 / z = 122

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            checker(br.readLine());
        }

        System.out.println(sb);
    }

    static void checker(String input) {
        String[] splitter = input.split(" ");

        for (int i = 0; i < splitter.length; i++) {
            if (splitter[i].isEmpty()) continue; // 빈 단어 예외 처리
            int check = Character.toLowerCase(splitter[i].charAt(0)) - 97;
            if (!is_used[check]) {
                addBetweenString(splitter, i, 0);
                is_used[check] = true;
                return;
            }
        }

        for (int i = 0; i < splitter.length; i++) {
            for (int j = 0; j < splitter[i].length(); j++) {
                int check = Character.toLowerCase(splitter[i].charAt(j)) - 97;
                if (!is_used[check]) {
                    addBetweenString(splitter, i, j);
                    is_used[check] = true;
                    return;
                }
            }
        }
        sb.append(input).append("\n");

    }

    static void addBetweenString(String[] words, int wordIdx, int charIdx) {
        for (int i = 0; i < words.length; i++) {
            if (i == wordIdx) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    if (j == charIdx) sb.append("[").append(word.charAt(j)).append("]");
                    else sb.append(word.charAt(j));
                }
            } else {
                sb.append(words[i]);
            }

            if (i < words.length - 1) sb.append(" ");
        }
        sb.append("\n");
    }

}
