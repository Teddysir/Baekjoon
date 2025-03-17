import java.io.*;
import java.util.*;

public class Main {

    static String[] strings;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }


        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    int num1 = 0;
                    int num2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9') {
                            num1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                        }
                    }

                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9') {
                            num2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }

                    if (num1 == num2) {
                        return o1.compareTo(o2);
                    } else {
                        return num1 - num2;
                    }
                }
            }
        });


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(strings[i]).append("\n");
        }

        System.out.println(sb);

    }

}
