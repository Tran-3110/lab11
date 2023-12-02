package main;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	//add
	public BNode<E> addHelper(BNode<E> root, E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			if (e.compareTo(root.data) > 0) {
				root.right = addHelper(root.right, e);
			} else {
				root.left = addHelper(root.left, e);
			}
		}
		return root;
	}
	
	//depth
	public int depthHelper(BNode<E> root, E e) {
		if (e.compareTo(root.data) == 0)
			return 0;
		else {
			if (e.compareTo(root.data) > 0) {
				return 1 + depthHelper(root.right, e);
			} else {
				return 1 + depthHelper(root.left, e);
			}
		}
	}

	//contains
	public boolean containsNode(BNode<E> root, E e) {
		if (root == null)
			return false;
		if (e.compareTo(root.data) == 0) {
			return true;
		} else {
			if (e.compareTo(root.data) > 0) {
				return containsNode(root.right, e);
			} else {
				return containsNode(root.left, e);
			}
		}
	}
	
	//height
	public int heightHelper(BNode<E> root) {
		if (root.left == null && root.right == null)
			return 0;
		else {
			if (root.left != null && root.right != null) {
				int heightLeft = 1 + heightHelper(root.left);
				int heightRight = 1 + heightHelper(root.right);
				return Math.max(heightLeft, heightRight);
			}
			if (root.right != null) {
				return 1 + heightHelper(root.right);
			} else {
				return 1 + heightHelper(root.left);
			}
		}
	}
	
	//size
	public int sizeHelper(BNode<E> root) {
		if (root == null)
			return 0;
		else {
			return 1 + sizeHelper(root.left) + sizeHelper(root.right);
		}
	}
	
	//remove
	public BNode<E> remove(BNode<E> root, E e) {
		if (e.compareTo(root.data) == 0) {
			return removeHelper(root);
		} else if (root.left != null && e.compareTo(root.left.data) == 0) {
			return root.left = removeHelper(root.left);
		} else if (root.right != null && e.compareTo(root.right.data) == 0) {
			return root.right = removeHelper(root.right);
		} else if (e.compareTo(root.data) > 0) {
			return remove(root.right, e);
		} else {
			return remove(root.left, e);
		}
	}

	public BNode<E> removeHelper(BNode<E> root) {
		// Node is leaf
		if (root.left == null && root.right == null) {
			root = null;
		}
		// Node has 2 children
		else if (root.left != null && root.right != null) {
			BNode<E> node = leastRight(root);
			if (node == null) {
				node = root.right;
				node.left = root.left;
				root = node;
				node = null;
			} else {
				node.right = root.right;
				node.left = root.left;
				root = node;
				node = null;
			}
		}
		// Node has only 1 children
		else if (root.left != null) {
			root = root.left;
		} else {
			root = root.right;
		}
		return root;
	}

	public BNode<E> leastRight(BNode<E> root) {
		BNode<E> par = root.right;
		BNode<E> cur = par.left;
		if (cur == null) {
			return cur;
		}
		while (cur != null && cur.left != null) {
			par = cur;
			cur = cur.left;
		}
		par.left = null;
		return cur;
	}
	
	public boolean isRoot(BNode<E> root, E e) {
		return e.compareTo(root.data) == 0;
	}
	
	//findMin
	public E findMinHelper(BNode<E> root) {
		if (root.left == null) {
			return root.data;
		} else {
			return findMinHelper(root.left);
		}
	}
	
	//findMax
	public E findMaxHelper(BNode<E> root) {
		if (root.right == null) {
			return root.data;
		} else {
			return findMaxHelper(root.right);
		}
	}
	
	//descendant
	public List<E> descendantHelper(BNode<E> node, E e) {
		List<E> list = new ArrayList<>();
		if (e.compareTo(node.data) != 0)
			list.add(node.data);
		if (node.left != null) {
			list.addAll(descendantHelper(node.left, e));
		}
		if (node.right != null) {
			list.addAll(descendantHelper(node.right, e));
		}
		return list;
	}
	
	//ancestor
	public List<E> ancestorsHelper(BNode<E> root, E e) {
		List<E> list = new ArrayList<>();
		if (root != null) {
			if (e.compareTo(root.data) != 0)
				list.add(root.data);
			if (e.compareTo(root.data) > 0) {
				list.addAll(ancestorsHelper(root.right, e));
			}
			else if (e.compareTo(root.data) < 0) {
				list.addAll(ancestorsHelper(root.left, e));
			}
		}
		return list;
	}

	public BNode<E> findBNode(BNode<E> root, E e) {
		if (e.compareTo(root.data) == 0) {
			return root;
		} else if (e.compareTo(root.data) < 0) {
			return findBNode(root.left, e);
		} else {
			return findBNode(root.right, e);
		}
	}

	public void inorderHelper(BNode<E> root) {
		if (root != null) {
			inorderHelper(root.left);
			System.out.println(root.data);
			inorderHelper(root.right);
		}
	}

	public void preorderHelper(BNode<E> root) {
		if (root != null) {
			System.out.println(root.data);
			inorderHelper(root.left);
			inorderHelper(root.right);
		}
	}

	public void postorderHelper(BNode<E> root) {
		if (root != null) {
			inorderHelper(root.left);
			inorderHelper(root.right);
			System.out.println(root.data);
		}
	}
}
