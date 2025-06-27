import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) throws Exception {

        int k = 6;
        int[] arr = new int[]{1, 3, 2, 5, 4, 5, 2, 3};


        System.out.println(solution(k, arr));
    }


    public static int solution(int k, int[] tangerine) {

        Arrays.sort(tangerine); // 배열 정렬 작은순서대로

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> arr = new ArrayList<>(map.values());
        arr.sort(Collections.reverseOrder());

        int num = 0; // 총 갯수
        int answer = 0; // 타입 수


        for(int i =0; i < arr.size(); i++){
            num+= arr.get(i);
            answer++;
            if(num >= k) {
                return answer;
            }
        }

        return answer;
    }


}


