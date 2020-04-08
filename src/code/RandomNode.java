package code;

import java.util.LinkedList;
import java.util.Queue;

public class RandomNode {
	private class Node{
		int data;
		Node left, right;
		int children;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
			this.children = -1;
		}
	}
	private Node root = null;
	
	public void createBinaryTree(int data) {
		Queue<Node> q = new LinkedList<>();
		if(root == null) {
			root = new Node(data);
			return;
		}else {
			q.add(root);
			while(!q.isEmpty()) {
				Node temp = q.remove();
				if(temp.left != null) {
					q.add(temp);
				}else {
					temp.left = new Node(data);
					return;
				}
				if(temp.right != null) {
					q.add(temp);
				}else {
					temp.right = new Node(data);
					return;
				}
			}
		}
	}
	
	public void addChildren(Node root) {
		if(root != null) {
			addChildren(root.left);
			root.children = numChildren(root) - 1;
			addChildren(root.right);
		  }
	}
	private int numChildren(Node root) {
		if(root == null) return 0;
		
		return numChildren(root.left) + numChildren(root.right) + 1;
		
	}
	
	private int getChildren(Node root) {
		if(root == null) return 0;
		return root.children + 1;
	}
	public Node getRandomNode() {
		int randomNum = (int)Math.random();
		return getChildrenUtil(root, randomNum);
		
	}
	public Node getChildrenUtil(Node root, int randomNum) {
		if(randomNum == getChildren(root.left)) return root;
		if(randomNum < getChildren(root.left))
			return getChildrenUtil(root.left, randomNum);
		return getChildrenUtil(root.right, randomNum - getChildren(root.left) - 1); 
	}
	
}
