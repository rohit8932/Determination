package code;

public class BST {
	static class Node{
		int data;
		Node left, right;
		Node(int v){
			this.data = v;
			this.left = null;
			this.right = null;
		}
	}
	Node root = null;
	//time- O(n) space- O(n) where n is number of nodes in tree currently
	public Node createBST(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}else if(data < root.data){
			root.left = createBST(root.left, data);
		}else {
			root.right = createBST(root.right, data);
		}
		return root;
	}
	
	//time- O(n) space- O(n) imagine skwed tree 
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public Node searchInBST(Node root, int data) {
		if(root != null) {
			if(root.data == data) {
				System.out.print("\nFound ");
				return root;
			}else if(data < root.data) {
				return searchInBST(root.left, data);
			}else {
				return searchInBST(root.right, data);
			}
		}
		return null;
	}
	
	public Node getParent(Node root, int data) {
		if(root != null) {
			if((root.left != null &&root.left.data == data) || (root.right!= null && root.right.data == data)) {
				return root;
			}else if(data < root.data){
				return getParent(root.left, data);
			}else {
				return getParent(root.right, data);
			}
		}
		return null;
	}
	
}
