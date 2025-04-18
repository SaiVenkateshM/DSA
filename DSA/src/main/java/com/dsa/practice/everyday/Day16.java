package com.dsa.practice.everyday;
/*
1. check if the tree is valid bst(Binary search tree)
2.
 */

public class Day16 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(2);
        A.left = new TreeNode(1);
        A.right = new TreeNode(3);
        int answer = isValidBST(A);
        System.out.println(answer);
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
}

