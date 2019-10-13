package CODE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	Node root;
	public BinaryTree() {
		root = null;
	}
	
	class Node{
		int data;
		Node left;
		Node right;
		
		Node(int d){
			this.data = d;
			this.left = null;
			this.right = null;
		}
	}
	//time- O(n)
	public void createBinaryTree(int data) {
		Queue<Node> q = new LinkedList<>();
		if(root == null) {
			root = new Node(data);
		}else {
			q.add(root);
			Node temp = null;
			while(!q.isEmpty()) {
				temp = q.remove();
				if(temp.left != null) {
					q.add(temp.left);
				}else {
					temp.left = new Node(data);
					return;
				}
				if(temp.right != null) {
					q.add(temp.right);
				}else {
					temp.right = new Node(data);
					return;
				}
			}
		}
	}
	
	//time- O(n) space-(logn)
	public void recursivePreOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			recursivePreOrder(root.left);
			recursivePreOrder(root.right);
		}
	}
	
	//time- O(n) space- O(logn)
	public void recursiveInorder(Node root) {
		if(root != null) {
			recursiveInorder(root.left);
			System.out.print(root.data + " ");
			recursiveInorder(root.right);
		}
	}
	
	//time- O(n) space- O(logn)
 	public void recursivePostOrder(Node root) {
		if(root != null) {
			recursivePostOrder(root.left);
			recursivePostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
 	//time- O(n) space- O(logn)
	public void preorder(Node root) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.empty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
			
		}
	}
	
	//time- O(n) space- O(logn)
	public void inorder(Node root) {
		Stack<Node> s = new Stack<BinaryTree.Node>();
		while(true) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			if(s.empty())
				break;
			
			Node temp = s.pop();
			if(temp != null) {
				System.out.print(temp.data + " ");
				root = temp.right;
			}
		}
	}
	
	//time- O(n) space- O(n)
	public void levelorder(Node root) {
		Queue<Node> q = new LinkedList<BinaryTree.Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
	}
	
	//time- O(n) space- O(n)
	public int findMaxValue() {
		int maxVal = -1;
		Stack<Node> s = new Stack<BinaryTree.Node>();
		s.push(root);
		while(!s.empty()) {
			Node temp = s.pop();
			if(temp.data > maxVal)
				maxVal = temp.data;
			
			if(temp.left != null) {
				s.push(temp.left);
			}
			if(temp.right != null) {
				s.push(temp.right);
			}
		}
		return maxVal;
	}
	
	//time- O(n) space- O(n)
	public boolean findValue(int data) {
		Queue<Node> q = new LinkedList<BinaryTree.Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(temp.data == data) {
				return true;
			}
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
		return false;
	}
	
	//time- O(n) space- O(logn) for safer side it is O(n) because consider situation for skewed tree
	public boolean findElementRecursion(Node root, int data) {
		if(root != null) {
			if(root.data == data) {
				return true;
			}
			return (findElementRecursion(root.left, data) || findElementRecursion(root.right, data));			
		}
		return false;
	}
	
	//time- O(n) space- O(n) for unbalnced for balanced it will be O(logn)
	public int sizeOfTree(Node root) {
		if(root != null)
			return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
		else
			return 0;
	}
	
	//time- O(n) space- 
	public void levelorderInReverse() {
		Queue<Node> q = new LinkedList<>();
		List<Integer> val = new ArrayList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			val.add(temp.data);
			if(temp.right != null) {
				q.add(temp.right);
			}
			
			if(temp.left != null) {
				q.add(temp.left);
			}
		}
		Collections.reverse(val);
		for(Integer i : val)
			System.out.print(i + " ");
	}
}
