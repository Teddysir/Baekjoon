public class Solution {
    public static void main(String[] args) {

        int[][] arr = {{3,5}, {4,1}, {2,4}, {5,10}};

        System.out.println(solution(arr));


    }

    public static int solution(int[][] dots) {

        if(checker(dots[0], dots[1], dots[2], dots[3])) {
            return 1;
        }
        
        if (checker(dots[0], dots[2], dots[1], dots[3])) {
            return 1;
        }
        if (checker(dots[0], dots[3], dots[1], dots[2])) {
            return 1;
        }
        
        return 0;


    }

    public static boolean checker(int[] a, int[] b, int[] c, int[] d) {
        return (b[1] - a[1]) * (d[0] - c[0]) == (d[1] - c[1]) * (b[0] - a[0]);
    }
}

// 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
// 0,1 / 0,2 / 0,3 / 1,2 / 1,3 / 2,3