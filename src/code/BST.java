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
	
	public boolean checkBST(Node root, int min, int max) {
		if(root == null) return true;
		
		if(root.data < min || root.data > max) return false;
			
		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
		
		
	}

//	public Node inorderSuccessor(Node root) {
//
//		if(root.right == null) {
//			Node temp = root.parent;
//			while(temp != null && temp.left == root) {
//				temp = temp.parent;
//			}
//		}
//		if(root.right.left == null) return root.right;
//		
//		root = root.right;
//		while(root.left != null) {
//			root = root.left;
//		}
//		return root;
//			
//	}
	
	// time- O(n) space- O(n)
	public Node commonAnchestor(Node root, int data1, int data2) {
		if(root == null) return null;
		if(root.data == data1 || root.data == data2) return root;
		
		Node left = commonAnchestor(root.left, data1, data2);
		Node right = commonAnchestor(root.right, data1, data2);
		
		if(left != null && right != null) {
			System.out.println("Common Anchestor found " + root.data);
			return root;
		}else if(left != null) {
			return left;
		}else
			return right;
		
	}
	
}
