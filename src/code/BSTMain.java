package code;

import code.BST.Node;

public class BSTMain {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.root = bst.createBST(bst.root,50);
		bst.root = bst.createBST(bst.root,40);
		bst.root = bst.createBST(bst.root,30);
		bst.root = bst.createBST(bst.root,45);
		bst.root = bst.createBST(bst.root,70);
		bst.root = bst.createBST(bst.root,75);
		bst.root = bst.createBST(bst.root,60);
		
		
//		bst.inorder(bst.root);
//		
//		System.out.print(bst.searchInBST(bst.root, 12).data);
		
//		bst.root.left.left = new Node(13);
//		System.out.println(bst.checkBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		
//		bst.root.right.left = new Node(11);
//		System.out.println(bst.inorderSuccessor(bst.root).data);
		
		bst.commonAnchestor(bst.root, 30, 45);
		
	}

}
