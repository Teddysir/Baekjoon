import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 2, 3};

        StringBuilder sb = new StringBuilder();
        sb.append(solution(nums));
        System.out.println(sb);

    }

    public static int solution(int[] nums) {
        int answer = 0;

        int choiceNum = nums.length / 2; // 고르는 포켓몬 수

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if(set.size() >= choiceNum) {
            answer = choiceNum;
        } else {
            answer = set.size();
        }

        return answer;
    }

}
