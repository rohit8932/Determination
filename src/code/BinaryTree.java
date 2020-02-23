package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.sql.CommonDataSource;

public class BinaryTree {
	Node root;
	int numLeafNode = 0;
	public BinaryTree() {
		root = null;
	}
	
	static class Node{
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
	
	//time- O(n) space- O(n)
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
	
	//time- O(n) space- O(logn)
	public void deleteTree(Node root) {
		if(root != null) {
			deleteTree(root.left);
			deleteTree(root.right);
			root.data = -1;
		}
	}
	
	//time- O(n) space- O(logn) for skewed tree it will be O(n)
	public int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
	}
	
	//time- O(n) space- O(n) because at all the leaf will be in queue and leaf is n/2 so approx n.
	public int heightOfTreeNonRecursive(Node root) {
		Queue<Node> q = new LinkedList<>();
		int height = 0;
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(temp != null) {
				if(temp.left != null) {
					q.add(temp.left);
				}
				if(temp.right != null) {
					q.add(temp.right);
				}			
			}else if(!q.isEmpty()){
				height += 1;
				q.add(null);
			}
		}
		return height;	
	}
	
	//time- O(n) space- O(logn) for balanced tree O(n) for skwed tree
	public int numLeafNode(Node root) {
		if(root != null) {
			numLeafNode(root.left);
			numLeafNode(root.right);
			if(root.left == null && root.right == null) {
				numLeafNode = numLeafNode + 1;
				return numLeafNode;
			}
		}
		return numLeafNode;
	}
	
	//time- O(n) space- O(log n)
	public Node minimalTree(int[] arr, int left, int right, Node root) {
		if(left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		
		root = new Node(arr[mid]);
		root.left = minimalTree(arr, left, mid - 1, root);
		root.right = minimalTree(arr, mid + 1, right, root);
		return root;
		
	}
	
	//time- O(n) space- O()
	public void listOfDepth(Node root) { //consiering unique node in tree
		Queue<Node> q = new LinkedList<>();
		List<code.LinkedList> ll = new ArrayList<>();
		q.add(root);
		q.add(null);
		int newLL = 0;
		code.LinkedList tempL = new code.LinkedList();
		ll.add(newLL, tempL);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(temp == null) {
				if(!q.isEmpty()) {
					q.add(null);
					tempL = new code.LinkedList();
					ll.add(++newLL, tempL);
				}
				continue;
			}else {
				tempL.insertInSinglyLL(temp.data);
			}
			if(temp.left != null) {
				q.add(temp.left);				
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
			
		}
		for(int i = 0; i < ll.size(); i++) {
			code.LinkedList.Node trav = ll.get(i).head;
			while(trav != null) {
				System.out.print(trav.data +  " ");
				trav = trav.next;
			}
			System.out.println();
		}
	}
	
	public boolean checkBalanced(Node root) {
		if(root != null) {
			int leftH = getHeight(root.left) -1;
			int rightH = getHeight(root.right) -1;
			if(leftH - rightH > 1 || leftH - rightH < -1) {
				System.out.println("The tree is unbalaned");
				return false;
			}
			return checkBalanced(root.left) && checkBalanced(root.right);
		}
		return true;
	}
	
	private int getHeight(Node root) {

		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		if(left > right) {
			return left + 1;
		}
		return right + 1;
	}
	
	//time- O(n) space- O(n)
	public void sumOfPath(Node root, int sum, int[] arr, int index) {
		if (root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			arr[index++] = root.data;
			for(int i  = 0;i < index; i ++) {
				System.out.print( arr[i] + " - > ");
			}
			System.out.println(" = " + (sum + root.data));
			return;
		}
		arr[index++] = root.data;
		sumOfPath(root.left, sum + root.data, arr, index);
		sumOfPath(root.right, sum + root.data, arr, index);
	}
	
	public int pathWithSum(Node root, int sum) {
		if(root == null) return 0 ;
		
		int numOfSumOnLeft = sumOnPath(root, sum, 0);
		int left = pathWithSum(root.left, sum);
		int right = pathWithSum(root.right, sum);
		return numOfSumOnLeft + left + right;
	}
	private int sumOnPath(Node root, int sum, int currSum) {
		if(root == null) return 0;
		int totalSum = 0;
		
		if(currSum == sum) {
			totalSum ++;
		}
		totalSum+= sumOnPath(root.left, totalSum, currSum + root.data);
		totalSum+= sumOnPath(root.right, totalSum, currSum + root.data);
		return totalSum;
	}

	public Node commonAnchestor(Node root, int data1, int data2) {
		if(root == null ) return null;
		Node left = commonAnchestor(root.left, data1, data2);
		Node right = commonAnchestor(root.right, data1, data2);
		
		if(left != null && right != null) {
			System.out.println("Common Anchestor is " + root.data);
		}
		if(root.data == data1 || root.data == data2) return root;
		
		if(left != null) 
			return left;
		else 
			return right;
		
	}
	
	//time- O(mn) space- O(height of tree)
	public boolean isSubtree(Node root1, Node root2) {
		if(root1 == null) return false;
		
		if(isIdentical(root1, root2))	return true;
		
		return (isSubtree(root1.left, root2) || isSubtree(root1.right, root2));
	}
	//time- O(n) space- O(height of tree2)
	private boolean isIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null) 	return true;
		
		if(root1 == null || root2 ==null)	return false;
		
		return (root1.data == root2.data && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right));
		
	}
	
}
