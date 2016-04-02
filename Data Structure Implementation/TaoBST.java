import java.util.*;

public class TaoBST {
	private class Node {
		int val;
		int count;
		Node left;
		Node right;
		int nodeNum;
		public Node (int val){
			this.val = val;
			this.left = null;
			this.right = null;
			this.count = 1;
			this.nodeNum = 1;
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
	public int size(Node cur){
		if (cur == null){
			return 0;
		}
		return cur.nodeNum;
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
		if (cur.val == val){
			cur.count++;
		}else if (val < cur.val){
			addRecursiveHelper(cur.left, cur, val);
		}else{
			addRecursiveHelper(cur.right, cur, val);
		}
		cur.nodeNum += 1;
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
		return selectHelper(cur, k);
	}
	public int selectHelper(Node cur, int k){
		//base case, we didn't find the target k
		if (cur == null){
			return Integer.MAX_VALUE;
		}
		//main body
		int leftTreeSize = size(cur.left);
		if (leftTreeSize < k - cur.count){
			return selectHelper(cur.right, k - leftTreeSize - cur.count);
		}else if (k - leftTreeSize >= 1 && k - leftTreeSize <= cur.count){
			return cur.val;
		}else{
			return selectHelper(cur.left, k);
		}

	}
	//核心是cur和value的比较
	//BST operation和普通binary tree的区别一般就是BST只往一边走，不是DC，而binary tree大多数都是DC
	public int rank(int k){
		Node cur = this.root;
		return rankHelper(k, cur);
	}
	public int rankHelper(int k, Node cur){
		//base case
		if (cur == null){
			return 0;
		}
		//main body
		if (k < cur.val){
			return rankHelper(k, cur.left);
		}else if (k > cur.val) {
			return size(cur.left) + cur.count + rankHelper(k, cur.right);
		}else{
			return size(cur.left) + cur.count;
		}
	}
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
	public int height(){
		Node cur = this.root;
		return heightHelper(cur);
	}
	public int heightHelper(Node cur){
		if (cur == null){
			return 0;
		}
		int leftHeight = heightHelper(cur.left);
		int rightHeight = heightHelper(cur.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	public ArrayList<Integer> inorderHelper(Node cur){
		//base case
		if (cur == null){
			return new ArrayList<Integer>();
		}
		//main body
		ArrayList<Integer> left = inorderHelper(cur.left);
		left.add(cur.val);
		left.addAll(inorderHelper(cur.right));
		return left;
	}
	public void deleteMin(){
		Node cur = this.root;
		Node prev = null;
		deleteMinHelper(cur, prev);
	}
	public void deleteMinHelper(Node cur, Node prev){
		//base case
		if (cur == null){
			return;
		}
		if (cur.left == null){
			prev.left = cur.right;
			this.size--;
			return;
		}
		deleteMinHelper(cur.left, cur);
		cur.nodeNum--;
	}
	public void deleteMax(){
		Node cur = this.root;
		Node prev = null;
		deleteMaxHelper(cur, prev);
	}
	public void deleteMaxHelper(Node cur, Node prev){
		//base case
		if (cur == null){
			return;
		}
		if (cur.right == null){
			prev.right = cur.left;
			this.size--;
			return;
		}
		deleteMaxHelper(cur.right, cur);
		cur.nodeNum--;
	}
	public void removeNode(int value) {
        // write your code here
        //edge case 
        if (root == null){
            return;
        }
        Node cur = root;
        Node prev = null;
        this.root = removeHelper(cur, prev, value);
    }
    public Node removeHelper(Node cur, Node prev, int value){
        //base case 1: not found
        if (cur == null){
            return null;
        }
        //base case 2: the target is the leaf node
        if (cur.val == value && cur.left == null && cur.right == null){
            if (prev == null){
                return null;
            }
            if (cur.val < prev.val){
                prev.left = null;
            }else{
                prev.right = null;
            }
            this.size--;
            return null;
        }
        //base case 3: the target has one child
        if (cur.val == value && (cur.left == null || cur.right == null)){
            Node toReturn = cur.left == null? cur.right : cur.left;
            if (prev == null){
                return toReturn;
            }
            if (cur.val < prev.val){
                prev.left = cur.left == null? cur.right : cur.left;
            }else{
                prev.right = cur.left == null? cur.right: cur.left;   
            }
            this.size--;
            return toReturn;
        }
        //base case 4: the target has two children
        if (cur.val == value && cur.left != null && cur.right != null){
            Node deletedMin = deleteMin(cur.right, cur);
            deletedMin.right = cur.right;
            deletedMin.left = cur.left;
            if (prev == null){
                return deletedMin;
            }
            if (cur.val < prev.val){
                prev.left = deletedMin;
            }else{
                prev.right = deletedMin;
            }
            this.size--;
            return deletedMin;
        }
        //main body
        if (value < cur.val){
            Node leftTree = removeHelper(cur.left, cur, value);
            cur.left = leftTree;
        }else{
            Node rightTree = removeHelper(cur.right, cur, value);
            cur.right = rightTree;
        }
        return cur;
    }
    public Node deleteMin(Node cur, Node prev){
        //base case
        if (cur == null){
            return null;
        }
        if (cur.left == null){
            Node toReturn = cur;
            prev.left = cur.right;
            return toReturn;
        }
        return deleteMin(cur.left, cur);
    }
    public ArrayList<Integer> searchRange(int k1, int k2){
    	Node cur = this.root;
    	return searchRangeHelper(cur, k1, k2);
    }
    public ArrayList<Integer> searchRangeHelper(Node root, int k1, int k2) {
        // write your code here
        if (root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (k1 < root.val){
            ArrayList<Integer> left = searchRangeHelper(root.left, k1, k2);
            result.addAll(left);
        }
        if (k1 <= root.val && root.val <= k2){
            result.add(root.val);
        }
        if (k2 > root.val){
            ArrayList<Integer> right = searchRangeHelper(root.right, k1, k2);
            result.addAll(right);
        }
        return result;
    }
	public static void main(String[] args){
		TaoBST bst = new TaoBST();
		bst.add(10);
		bst.add(6);
		bst.add(3);
		bst.add(7);
		bst.add(9);
		bst.add(12);
		bst.add(11);
		bst.add(100);
		bst.add(99);
		bst.add(4);
		

		System.out.println(bst.size());
		ArrayList<Integer> traverse = bst.inorder();
		for (int i : traverse){
			System.out.print(i + " ");
		}
		System.out.println("");
		//remove node
		bst.removeNode(10);
		System.out.println(bst.size());
		traverse = bst.inorder();
		for (int i : traverse){
			System.out.print(i + " ");
		}
		System.out.println("");

		ArrayList<Integer> range = bst.searchRange(3, 15);
		for (int i : range){
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}