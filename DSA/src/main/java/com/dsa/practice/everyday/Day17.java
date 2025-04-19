package com.dsa.practice.everyday;


/*
1. Search in BST

 */
public class Day17 {
    public static void main(String[] args) {
        int find = 16;
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.left.left.left = new TreeNode(8);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(27);

        int answer = find(root, find);
        System.out.println(answer);
        int B = 8;
        TreeNode finalNode = deleteNodeWithSingleChildNode(root, B);
        print(finalNode);
    }

    public static int find(TreeNode root, int find) {
        if (root == null)
            return 0;
        if (root.val == find) {
            return 1;
        } else if (find < root.val) {
            return find(root.left, find);
        } else {
            return find(root.right, find);
        }
    }

    public static TreeNode deleteNodeWithSingleChildNode(TreeNode root, int B) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        // TreeNode nodeTobedeleted = findNode(current,B);
        TreeNode parent = null;
        while (current != null) {

            if (current.val > B) {
                parent = current;
                current = current.left;
            } else if (current.val < B) {
                parent = current;
                current = current.right;
            } else {
                if (current.val == B) {
                    if (current.left == null && current.right == null) { // when there is no child node
                        if (parent.left == current) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    } else if (current.left == null && current.right != null) { // when there is 1 child node
                        if (parent.left == current) {
                            parent.left = current.right;
                        } else {
                            parent.right = current.right;
                        }
                    } else if (current.left != null && current.right == null) {
                        if (parent.left == current) {
                            parent.left = current.left;
                        } else {
                             parent.right = current.left;
                        }
                    }
                }
                break;
            }
        }
        return root;
    }
    public static void print(TreeNode A){
        TreeNode current = A;
        if(current == null)
            return;
        print(current.left);
        System.out.print(current.val + "-");//inorder
        print(current.right);
        //System.out.print(current.val + "-");//post order

    }
}
