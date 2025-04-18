import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            for (int j = 0; j < commands[i].length; j++) {
                int cutStart = commands[i][0]; // 2
                int sortEnd = commands[i][1]; // 5
                int findNum = commands[i][2]; // 3

                List<Integer> list = new ArrayList<>();
                for(int k = cutStart-1; k < sortEnd; k++) {
                    list.add(array[k]);
                }

                Collections.sort(list);
                int num = list.get(findNum-1);
                answer[i] = num;

            }
        }

        return answer;
    }
}
