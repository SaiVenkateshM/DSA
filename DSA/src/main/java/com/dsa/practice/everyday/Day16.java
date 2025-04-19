package com.dsa.practice.everyday;
/*
1. check if the tree is valid bst(Binary search tree)
2. Sorted Balanced Binary Search Tree.

 */

public class Day16 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(2);
        A.left = new TreeNode(1);
        A.right = new TreeNode(3);
        int answer = isValidBST(A);
        System.out.println(answer);

        int[] arrays = {1, 2, 3,4, 5, 8,10};

        TreeNode answer1 = createBBST(arrays);
        print(answer1);
    }

    public static int isValidBST(TreeNode A){
        if(isBST(A,null,null)){
            return 1;
        }else{
            return 0;
        }
    }

    public static boolean isBST(TreeNode A,Integer min, Integer max){
        if(A == null)
            return true;
        if((min !=null && A.val <= min) || (max != null && A.val >= max)){
            return false;
        }
        return (isBST(A.left,min,A.val) && isBST(A.right,A.val,max));

    }

    public static TreeNode createBBST(int[] A){
        // to make it balanced first take the middle element.
        int len = A.length;
        int start = 0;
        int end = len - 1;

        TreeNode answertree = balancedBST(A,start,end);
        return answertree;
    }

    public static TreeNode balancedBST(int[] A,int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;

        TreeNode root = new TreeNode(A[mid]);
        root.left = balancedBST(A,start,mid -1);
        root.right = balancedBST(A,mid+1,end);

        return root;
    }

    public static void print(TreeNode A){
        TreeNode current = A;
        if(current == null)
            return;
        print(current.left);

        print(current.right);
        System.out.print(current.val + "-");//post order

    }
}

