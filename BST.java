package main;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			root.addHelper(root, e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (contains(node)) {
			return root.depthHelper(root, node);
		}
		return -1;
	}

	// compute the height of BST
	public int height() {
		if (root != null) {
			return root.heightHelper(root);
		}
		return -1;
	}

	// Compute total nodes in BST
	public int size() {
		if (root != null) {
			return root.sizeHelper(root);
		}
		return -1;
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root != null) {
			return root.containsNode(root, e);
		}
		return false;
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null)
			return null;
		return root.findMinHelper(root);
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null)
			return null;
		return root.findMaxHelper(root);
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (contains(e)) {
			if (root.isRoot(root, e)) {
				root = root.remove(root, e);
			} else {
				root.remove(root, e);
			}
			return true;
		}
		return false;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		if (contains(data)) {
			return root.descendantHelper(root.findBNode(root, data), data);
		}
		return null;
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (contains(data)) {
			return root.ancestorsHelper(root, data);
		}
		return null;
	}

	// display BST using inorder approach
	public void inorder() {
		if (root != null) {
			root.inorderHelper(root);
		}
	}

	// display BST using preorder approach
	public void preorder() {
		if (root != null) {
			root.preorderHelper(root);
		}
	}

	// display BST using postorder approach
	public void postorder() {
		if (root != null) {
			root.postorderHelper(root);
		}
	}
}
