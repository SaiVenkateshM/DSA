package com.dsa.practice.everyday;

import java.util.Stack;

/*
1. Sort the given stack in ascending order.
2.
 */
public class Day5 {
    public static void main(String[] args) {
        Stack<Integer> givenStack = new Stack<>();
        givenStack.push(3);
        givenStack.push(1);
        givenStack.push(4);
        givenStack.push(2);
        givenStack.push(5);

        System.out.println("original Stack: "+ givenStack);
        Stack<Integer> answer = sortStack(givenStack);
        System.out.println("Sorted Stack: "+ answer);
    }
    public static Stack sortStack(Stack<Integer> stack){
        Stack<Integer> auxilaryStack = new Stack<>();

        while(!stack.isEmpty()){
            int temp = stack.peek();
            stack.pop();
            while(!auxilaryStack.isEmpty() && auxilaryStack.peek() > temp){
                int x = auxilaryStack.peek();
                auxilaryStack.pop();
                stack.push(x);
            }
            auxilaryStack.push(temp);
        }

        while(!auxilaryStack.isEmpty()){
            int x = auxilaryStack.peek();
            auxilaryStack.pop();
            stack.push(x);
        }
        return stack;
    }
}
