import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) {
                break;
            }
            sb.append(logic1(str)).append('\n');
        }
        System.out.println(sb);
    }

    private static String logic1(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< str.length(); i++ ){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[') {
                stack.push(ch);
            }

            else if(ch == ')') {
                if(stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

            else if(ch == ']') {
                if(stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

        }

        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }


}