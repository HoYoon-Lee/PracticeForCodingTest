package baekjoon.bj1991_트리순회;

import java.io.*;
import java.util.StringTokenizer;

class TreeNode{
    String root;
    TreeNode left, right;

    public TreeNode(String root) {
        this.root = root;
    }
}

public class Main {
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeNode head = new TreeNode("A");

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            addChild(head, st.nextToken(" "), st.nextToken(" "), st.nextToken());
        }
        br.close();

        preOrder(head);
        bw.write("\n");
        inOrder(head);
        bw.write("\n");
        postOrder(head);

        bw.close();
    }

    private static void addChild(TreeNode head, String root, String left, String right){
        if(head == null) return;
        if(head.root.equals(root)){
            if(!left.equals("."))
                head.left = new TreeNode(left);
            if(!right.equals("."))
                head.right = new TreeNode(right);
        }
        else{
            addChild(head.left, root, left, right);
            addChild(head.right, root, left, right);
        }
    }

    private static void preOrder(TreeNode root) throws IOException{
        if(root != null) {
            bw.write(root.root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void inOrder(TreeNode root) throws IOException{
        if(root != null){
            inOrder(root.left);
            bw.write(root.root);
            inOrder(root.right);
        }
    }

    private static void postOrder(TreeNode root) throws IOException{
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            bw.write(root.root);
        }
    }
}
