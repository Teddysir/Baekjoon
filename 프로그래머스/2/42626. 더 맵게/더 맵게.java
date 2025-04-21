import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));

    }
    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙 생성

        if(scoville.length <= 1) {
            return -1;
        }

        for (int scove : scoville) {
            minHeap.add(scove);
        }


        int count = 0;
        while (minHeap.peek() < K) {
            
            if(minHeap.size() <= 1) {
                return -1;
            }

            int first = minHeap.poll();
            int second = minHeap.poll();

            int temp = first + (second * 2);

            minHeap.add(temp);
            count++;

        }

        return count;

    }
}
