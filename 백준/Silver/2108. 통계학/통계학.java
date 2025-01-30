import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numList = new int[N];

        for (int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numList);

        br.close();

        bw.write(answer1(numList) + "\n"); //산술 평균
        bw.write(answer2(numList) + "\n"); //중앙 값
        bw.write(answer3(numList) + "\n"); //최빈 값
        bw.write(answer4(numList) + "\n"); //범위(최대와 최소의 차이) 값

        bw.flush();
        bw.close();

    }

    static int answer1(int[] numList) {
        int count = 0;
        for (int i = 0; i < numList.length; i++) {
            count += numList[i];
        }

        return (int) Math.round(((count * 10.0) / numList.length) * 0.1);
    }

    static int answer2(int[] numList) {
        int middle = numList.length / 2;

        return numList[middle];
    }

    // 최빈값좀 생각해봐야할듯

    static int answer3(int[] numList) {

        Map<Integer, Integer> mp = new HashMap<>();

        if (numList.length == 1) {
            return numList[0];
        }

        for (int i = 0; i < numList.length; i++) {
            if (mp.containsKey(numList[i])) {
                mp.put(numList[i], mp.get(numList[i]) + 1);
            } else {
                mp.put(numList[i], 1);
            }
        }

        int maxValue = Collections.max(mp.values());

        List<Integer> maxList = new ArrayList<>();

        for(Map.Entry<Integer, Integer> newMap : mp.entrySet()) {
            if(newMap.getValue() == maxValue) {
                maxList.add(newMap.getKey());
            }
        }

        Collections.sort(maxList);

        if(maxList.size() > 1) {
            return maxList.get(1);
        } else {
            return maxList.get(0);
        }


    }

    static int answer4(int[] numList) {
            int first = numList[0];
            int last = numList[numList.length - 1];

            return Math.abs(last - first);

    }

}

