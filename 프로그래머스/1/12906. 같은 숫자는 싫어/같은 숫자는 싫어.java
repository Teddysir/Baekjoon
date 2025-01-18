import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
List<Integer> list = new ArrayList<>();
        int val = -1;

        for (int i = 0; i< arr.length ; i++) {
            if(arr[i] != val) {
                list.add(arr[i]);
                val = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++ ) {
            answer[i] = list.get(i);
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}