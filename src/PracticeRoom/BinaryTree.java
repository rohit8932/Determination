package PracticeRoom;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	Node root = null;
	public void insert(int data) {
		if(this.root == null) {
			this.root = new Node(data);
		}else {
			Queue<Node> q = new LinkedList<>();
			q.add(this.root);
			while(true) {
				Node temp = q.remove();
				if(temp.left != null) {
					q.add(temp.left);
				}else {
					temp.left = new Node(data);
					break;
				}
				if(temp.right != null) {
					q.add(temp.right);
				}else {
					temp.right = new Node(data);
					break;
				}
			}
		}
	}
	
	public void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
		
		
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(10);
		bt.insert(11);
		bt.insert(12);
		bt.insert(13);
		
		bt.preorder(bt.root);
	}

}
