package com.dsa.practice.everyday;
/*
1. Inorder Traversal -- binary tree
2. Create binary tree from Inorder and Postorder.
 */

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Day4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Inorder");
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> integers = inorderTraversal(root,ans);
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 1, 3, 2));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(6, 3, 2, 1));
        TreeNode answer = buildTree(A,B);
        System.out.println(integers);


    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root,ArrayList<Integer> ans){
        TreeNode current = root;


        if(current == null)
            return ans;
        inorderTraversal(current.left,ans);
        //System.out.println(current.val);
        ans.add(current.val);
        inorderTraversal(current.right,ans);

        return ans;
    }

    public static TreeNode buildTree(ArrayList<Integer>A,ArrayList<Integer>B){
        int len = A.size();
        if(len <= 0)
            return null;
        int rootValue = B.get(len-1);
        int rootIndex = 0;
        for(int i=0;i<len;i++) {
            if (A.get(i) == rootValue) {
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootValue);

        ArrayList<Integer> leftChildInorder = new ArrayList<>();
        ArrayList<Integer> rightChildInorder = new ArrayList<>();
        for(int i=0;i<rootIndex;i++){
            leftChildInorder.add(A.get(i));
        }
        for(int j=rootIndex+1;j<len;j++){
            rightChildInorder.add(A.get(j));
        }
        ArrayList<Integer> leftChildPostorder = new ArrayList<>();
        ArrayList<Integer> rightChildPostorder = new ArrayList<>();
        for(int i=0;i<rootIndex;i++){
            leftChildPostorder.add(B.get(i));
        }
        for(int j=rootIndex;j<len-1;j++){
            rightChildPostorder.add(B.get(j));
        }
        root.left = buildTree(leftChildInorder,leftChildPostorder);
        root.right = buildTree(rightChildInorder,rightChildPostorder);

        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val =x;
        left=null;
        right = null;

    }
}

