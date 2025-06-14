package com.dsa.practice.everyday;

import java.util.*;

/* heap questions.
1. A th largest element (8th june 2025)
2. Merge K Sorted Lists

 */
public class Day8 {
    public static void main(String[] args) {
        int A = 4;
        List<Integer> B = Arrays.asList(1,2,3,4,5,6);
        List<Integer> answer = AthLargestElement(A,B);
        System.out.println(answer);
        ListNode l1 = buildList(new int[]{1, 10, 20});
        ListNode l2 = buildList(new int[]{4, 11, 13});
        ListNode l3 = buildList(new int[]{3, 8, 9});

        List<ListNode> lists = Arrays.asList(l1, l2, l3);

        ListNode merged = mergeKLists(lists);
        printList(merged);
    }


    public static List<Integer> AthLargestElement(int A,List<Integer>B){
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for( int num : B){
            minheap.offer(num);
            if(minheap.size() < A){
                result.add(-1);
            }else{
                if(minheap.size() > A){
                    minheap.poll();
                }
                result.add(minheap.peek());
            }
        }
        return result;
    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int val : arr) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists(List<ListNode> a){
        ListNode answer = new ListNode(-1);
        ListNode tail = answer;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(b-> b.val));
        //Insert head of all the linked list
        for(ListNode ln : a){
            if(ln != null){
                pq.offer(ln);
            }
        }

        while(!pq.isEmpty()){
            ListNode smallestNode = pq.poll();
            tail.next = smallestNode;
            tail = tail.next;
            if(smallestNode.next != null){
                pq.offer(smallestNode.next);
            }
        }
        // Time Complexity = kn(log k) k being the list size and n being the lenth of each linkedlistnode and log k for insertion.
        // space = log(k)
        return answer.next;
    }

    public static void printList(ListNode answer){
        ListNode head = answer;
        while (head != null){
            System.out.print(head.val +"->");
            head = head.next;
        }
    }


}
