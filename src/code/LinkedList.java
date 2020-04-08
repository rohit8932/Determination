package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LinkedList {
	static class Node{
		int data;
		Node next, prev;
		Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	Node head = null;
	
	//time- O(n) space- O(1)
	public void insertInSinglyLL(int data) {
		if(head == null) {
			head = new Node(data);
		}else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(data);
		}
	}
	
	//time- o(n) time- O(1)
	public void traverseInLL() {
		Node temp = this.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	//time- O(n) space- O(1)
	public int size() {
		Node head = this.head;
		if(head == null) return 0;
		int size = 0;
		while(head != null) {
			size ++;
			head = head.next;
		}
		return size;
	}
	
	//time- O(n) time- O(1)
	public int returnKthToLast_Iterative(int k) {
		Stack<Node> s = new Stack<>();
		Node trav = this.head;
		for(int i = 0; i < size(); i ++) {
			s.push(trav);
			trav = trav.next;
		}
		
		for(int i = 0; i < k; i++) {
			s.pop();
		}
		return s.peek().data;
	}
	
	public int returnKthToLast_Recursive(Node head, int k, int size) {
		if(size == k) return head.data;
		return returnKthToLast_Recursive(head.next, k, size-1);
	}
	
	public Node returnNode(Node head, int data) {
		while(head != null) {
			if(head.data == data)
				return head;
			head = head.next;
		}
		return null;
	}
	public void deleteInMiddle(Node toDelete) {
		if(toDelete == null) return;
		
		while(toDelete != null) {
			toDelete.data = toDelete.next.data;
			if(toDelete.next.next == null) toDelete.next = null;
			
			toDelete = toDelete.next;
		}
	}
	
	//time- O(maxLen(L1, L2)) space- O(len(L1) + len(L2)) 
	public LinkedList Sum(LinkedList L1, LinkedList L2) {
		Stack <Integer> s1 = new Stack<>();
		Stack <Integer> s2 = new Stack<>();
		Node trav1 = L1.head;
		Node trav2 = L2.head;
		while(trav1 != null) {
			s1.add(trav1.data);
			trav1 = trav1.next;
		}
		while(trav2 != null) {
			s2.add(trav2.data);
			trav2 = trav2.next;
		}
		LinkedList L3 = new LinkedList();
		L3.insertInSinglyLL(s1.pop() + s2.pop());
		while(!s1.empty()) {
			if(!s2.empty())
				L3.insertInSinglyLL(s1.pop() + s2.pop());
			else
				L3.insertInSinglyLL(s1.pop());
		}
		while(!s2.empty()) {
			L3.insertInSinglyLL(s2.pop());
		}
		return L3;
	}
	
	//time- O(len(ll)) space- O(len(ll))
	public boolean isPalindrome(LinkedList ll) {
		Stack<Integer> s = new Stack<>();
		Node trav = ll.head;
		int size = ll.size();
		
		for(int i = 0; i < size; i++){
			s.add(trav.data);
			trav = trav.next;
		}
		trav = ll.head;
		while((!s.empty()) && size != 0) {
			if(trav.data != s.pop()) {
				System.out.println("LinkedList is not palindrome");
				return false;
			}
			trav = trav.next;
			size --;
		}
		System.out.println("yes LinkedList is palindrome ");
		return true;
	}
	
	public Node LoopDetection(LinkedList ll) {
		return null;
	}
	
}
