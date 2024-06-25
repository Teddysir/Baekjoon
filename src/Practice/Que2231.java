package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Que2231 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 글자를 입력받는애

        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("apple");

        for(String arr : set)
            System.out.println(arr);

        List<String> arr = new ArrayList<>();
        arr.add("apple");
        arr.add("banana");
        arr.add("cananan");

        for(String fruit : arr)
            System.out.println(fruit);

//        int M = Integer.parseInt(br.readLine()); // 216
//
//        int N = 0;
//
//        for (int i = 0; i < M; i++) {
//            int num = i; // 0~ 216
//            int sum = 0; // 0
//
//            while (num != 0) {
//                sum += num % 10;
//                num /= 10;
//            }
//
//            if(i+sum == M) {
//                N = i;
//                break;
//            }
//
//        }
//        System.out.println(N);
    }
}
