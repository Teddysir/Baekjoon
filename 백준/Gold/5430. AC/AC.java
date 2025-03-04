import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int dCount = 0;
            char[] arr = new char[input.length()];
            for (int j = 0; j < input.length(); j++) {
                arr[j] = input.charAt(j);
                if (arr[j] == 'D') {
                    dCount++;
                }
            }

            int numInput = Integer.parseInt(br.readLine());
            int[] numArr = new int[numInput];

            String strNumInput = br.readLine();
            String newStrNumInput = strNumInput.substring(1, strNumInput.length() - 1);

            if (newStrNumInput.isEmpty()) {
                if(dCount == 0) { // 이부분이 문제였음 만약 빈 배열일경우 RRR 인데 errro가 붙음
                    sb.append(solution(numArr, arr)).append("\n");
                    continue;
                }
                sb.append("error").append("\n");
                continue;
            }

            String[] splitStr = newStrNumInput.split(",");
            for (int j = 0; j < splitStr.length; j++) {
                numArr[j] = Integer.parseInt(splitStr[j]);
            }

            if (dCount > numArr.length) {
                sb.append("error").append("\n");
            } else {
                sb.append(solution(numArr, arr)).append("\n");
            }

        }

        System.out.println(sb);


    }

    static String solution(int[] arr, char[] charArr) {

        Deque<Integer> linkedList = new LinkedList<>();
        boolean isReverse = false;

        for (int i = 0; i < arr.length; i++) { // 일단 linked에 다넣고
            linkedList.offerLast(arr[i]);
        }

        for(int k = 0 ; k < charArr.length; k++ ) {
            if(charArr[k] == 'R') {
                isReverse = !isReverse;
            } else {
                if(isReverse) {
                    linkedList.pollLast();
                } else {
                    linkedList.pollFirst();
                }
            }

        }
        int count = 0;

        int[] newArr = new int[linkedList.size()];
        if(isReverse) {
            while (!linkedList.isEmpty()) {
                newArr[count] = linkedList.pollLast();
                count++;
            }
        } else {
            while (!linkedList.isEmpty()) {
                newArr[count] = linkedList.pollFirst();
                count++;
            }
        }

        return Arrays.toString(newArr).replace(", ", ",");

    }


}
