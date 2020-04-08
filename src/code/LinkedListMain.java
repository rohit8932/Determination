package code;

public class LinkedListMain {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
//		ll.insertInSinglyLL(1);
//		ll.insertInSinglyLL(2);
//		ll.insertInSinglyLL(3);
//		ll.insertInSinglyLL(4);
//		ll.insertInSinglyLL(5);
		
//		ll.traverseInLL();
//		System.out.println(ll.returnKthToLast_Iterative(1));
//		System.out.println(ll.returnKthToLast_Recursive(ll.head, 1, ll.size()-1));
		
		
//		ll.deleteInMiddle(ll.returnNode(ll.head, 59	));
//		ll.traverseInLL();
		
//		LinkedList L1 = new LinkedList();
//		L1.insertInSinglyLL(1);
//		L1.insertInSinglyLL(2);
//		L1.insertInSinglyLL(3);
//		
//		LinkedList L2 = new LinkedList();
//		L2.insertInSinglyLL(6);
//		L2.insertInSinglyLL(7);
//		L2.insertInSinglyLL(1);
//		L2.insertInSinglyLL(10);
//		
//		LinkedList L3 = L1.Sum(L1, L2);
//		L3.traverseInLL();
		
//		LinkedList palindrome = new LinkedList();
//		palindrome.insertInSinglyLL(1);
//		palindrome.insertInSinglyLL(2);
//		palindrome.insertInSinglyLL(5);
//		palindrome.insertInSinglyLL(3);
//		palindrome.insertInSinglyLL(1);
//		palindrome.isPalindrome(palindrome);
		
		LinkedList circularLinkedList = new LinkedList();
		LinkedList.Node temp = new LinkedList.Node(10);
		circularLinkedList.insertInSinglyLL(1);
		circularLinkedList.head.next = temp;
		circularLinkedList.head.next.next = temp;
		circularLinkedList.LoopDetection(circularLinkedList);
		
		
	}
	

}
