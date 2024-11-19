import java.util.*;
import java.util.LinkedList;

class Node {
	int info;
	Node llink;
	Node rlink;

	Node(int item) {
		this.info = item;
		this.llink = null;
		this.rlink = null;
	}
}

class BinaryTree {
	Node root;

	void input(int item) {
		Node newNode = new Node(item);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (item < current.info) {
				current = current.llink;
				if (current == null) {
					parent.llink = newNode;
					return;
				}
			} else {
				current = current.rlink;
				if (current == null) {
					parent.rlink = newNode;
					return;
				}
			}
		}
	}

	void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.llink);
			System.out.print(node.info + " ");
			inOrderTraversal(node.rlink);
		}
	}

	void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.info + " ");
			preOrderTraversal(node.llink);
			preOrderTraversal(node.rlink);
		}
	}

	void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.llink);
			postOrderTraversal(node.rlink);
			System.out.print(node.info + " ");
		}
	}

	void inOrderTraversal() {
		inOrderTraversal(root);
	}

	void preOrderTraversal() {
		preOrderTraversal(root);
	}

	void postOrderTraversal() {
		postOrderTraversal(root);
	}

	void BFS() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		System.out.println("BFS Traversal: ");
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			System.out.print(current.info + " ");

			if (current.llink != null) {
				queue.add(current.llink);
			}
			if (current.rlink != null) {
				queue.add(current.rlink);
			}
		}
		System.out.println();
	}
	void DFS() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		System.out.println("BFS Traversal: ");
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.info + " ");

			if (current.llink != null) {
				stack.push(current.llink);
			}
			if (current.rlink != null) {
				stack.push(current.rlink);
			}
		}
		System.out.println();
	}

	int findMax(Node rootNode) {
		if (rootNode == null) {
			return Integer.MIN_VALUE; // For null child nodes, return the smallest possible integer.
		}
		int res = rootNode.info;
		int lres = findMax(rootNode.llink);
		int rres = findMax(rootNode.rlink);
	
		if (lres > res) res = lres;
		if (rres > res) res = rres;
		return res;
	}
	
	int findMin(Node rootNode) {
		if (rootNode == null) {
			return Integer.MAX_VALUE; // For null child nodes, return the largest possible integer.
		}
		int res = rootNode.info;
		int lres = findMin(rootNode.llink);
		int rres = findMin(rootNode.rlink);
	
		if (lres < res) res = lres;
		if (rres < res) res = rres;
		return res;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.input(50);
		tree.input(30);
		tree.input(70);
		tree.input(45);
		tree.input(40);
		tree.input(60);
		tree.input(90);
		System.out.println("In-order traversal:");
		tree.inOrderTraversal();
		System.out.println("\nPre-order traversal:");
		tree.preOrderTraversal();
		System.out.println("\nPost-order traversal:");
		tree.postOrderTraversal();
		System.out.println();

		tree.BFS();
		tree.DFS();
		System.out.println("Max element: " + tree.findMax(tree.root));
		System.out.println("Min element: " + tree.findMin(tree.root));
	}
} 

