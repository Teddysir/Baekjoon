import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        Node left;
        Node right;
        int num;

        public Node(int num) {
            left = null;
            right = null;
            this.num = num;
        }

        public void addNode(Node node) {
            if(this.num > node.num) {
                if(this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
            } else {
                if(this.right == null) {
                    this.right = node;
                } else {
                    this.right.addNode(node);
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            int num = Integer.parseInt(line);

            root.addNode(new Node(num));
        }

        postOrder(root);

    }

     public static void postOrder(Node node) {  // -> 전위순회 root - 왼 - 오

        if(node == null) {
            return;
        }

         postOrder(node.left);
         postOrder(node.right);
        System.out.println(node.num);
    }

}

