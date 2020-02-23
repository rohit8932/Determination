package code;

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
	
	public void traverseInLL() {
		Node temp = this.head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
