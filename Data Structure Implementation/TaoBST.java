import java.util.*;

public class TaoBST {
	private class Node {
		int val;
		Node left;
		Node right;
		public Node (int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	Node root;
	int size;
	public TaoBST (){
		root = null;
		size = 0;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public int size(){
		return size;
	}
	public boolean contains(int val){
		Node cur = this.root;
		return containsHelper(cur, val);
	}
	public boolean containsHelper(Node cur, int val){
		//base case
		if (cur == null){
			return false;
		}
		//main body
		if (cur.val == val){
			return true;
		}else if (val < cur.val){
			return containsHelper(cur.left, val);
		}else {
			return containsHelper(cur.right, val);
		}
	}
	//核心是prev pointer
	public boolean add(int val){
		if (contains(val)){
			return false;
		}
		if (this.root == null){
			this.root = new Node(val);
			this.size++;
			return true;
		}
		Node cur = this.root;
		Node prev = null;
		addRecursiveHelper(cur, prev, val);
		this.size++;
		return true;
	}
	public void addRecursiveHelper(Node cur, Node prev, int val){
		//base case
		if (cur == null){
			if (val < prev.val){
				prev.left = new Node(val);
			}else{
				prev.right = new Node(val);
			}
			return;
		}
		//main body
		if (val < cur.val){
			addRecursiveHelper(cur.left, cur, val);
		}else{
			addRecursiveHelper(cur.right, cur, val);
		}
	}
	//核心是一路向右
	public int max(){
		Node cur = this.root;
		return maxHelper(cur);
	}
	public int maxHelper(Node cur){
		//base case
		if (cur == null){
			return Integer.MIN_VALUE;
		}
		if (cur.right == null){
			return cur.val;
		}
		//main body
		return maxHelper(cur.right);
	}
	//核心是一路向左
	public int min(){
		Node cur = this.root;
		return minHelper(cur);
	}
	public int minHelper(Node cur){
		//base case
		if (root == null){
			return Integer.MAX_VALUE;
		}
		if (root.left == null){
			return root.val;
		}
		//main body
		return minHelper(root.left);
	}
	//return the larget num small than or less than val
	//核心是往右走纪录prev pointer
	public int floor(int val){
		Node cur = this.root;
		Node prev = null;
		return floorHelper(cur, prev, val);
	}
	public int floorHelper(Node cur, Node prev, int val){
		//base case
		if (cur == null){
			return prev.val;
		}
		//main body
		if (val == cur.val){
			return cur.val;
		}else if (val < cur.val){
			return floorHelper(cur.left, prev, val);
		}else{
			prev = cur;
			return floorHelper(cur.right, prev, val);
		}
	}
	//核心是往左走纪录prev pointer
	public int ceiling(int val){
		Node cur = this.root;
		Node prev = null;
		return ceilingHelper(cur, prev, val);
	}
	public int ceilingHelper(Node cur, Node prev, int val){
		//base case
		if (cur == null){
			return prev.val;
		}
		//main body
		if (cur.val == val){
			return cur.val;
		}else if (val < cur.val){
			prev = cur;
			return ceilingHelper(cur.left, prev, val);
		}else{
			return ceilingHelper(cur.right, prev, val);
		}
	}
	//核心是左子树和K的比较
	public int select(int k){
		Node cur = this.root;
		return selectHelper(cur, k)
	}
	//核心是cur和value的比较
	//BST operation和普通binary tree的区别一般就是BST只往一边走，不是DC，而binary tree大多数都是DC
	public rank()
	public ArrayList<Integer> inorder(){
		Node cur = this.root;
		return inorderHelper(cur);
	}
	private class Pair {
		ArrayList<Integer> arr;
		int kth;
		public Pair (ArrayList<Integer> arr, int kth){
			this.arr = arr;
			this.kth = kth;
		}
	}
	public ArrayList<Integer> inorderHelper(Node cur){
		//base case
		if (cur == null){
			return new ArrayList<Integer>();
		}
		if ()
		//main body
		ArrayList<Integer> left = inorderHelper(cur.left);
		left.add(cur.val);
		left.addAll(inorderHelper(cur.right));
		return left;
	}
	public static void main(String[] args){
		TaoBST bst = new TaoBST();
		bst.add(10);
		bst.add(6);
		bst.add(3);
		bst.add(7);
		bst.add(9);
		bst.add(11);
		bst.add(100);
		bst.add(99);
		bst.add(103);
		System.out.println(bst.ceiling(12));
		System.out.println(bst.ceiling(7));
		System.out.println(bst.ceiling(8));

		ArrayList<Integer> traverse = bst.inorder();
		for (int i : traverse){
			System.out.print(i + " ");
		}
	}
}