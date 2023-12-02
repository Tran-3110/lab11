package main;

import java.util.ArrayList;
import java.util.List;

public class TestBTS {
	public static void main(String[] args) {
		BST<Integer> bts = new BST<>();
//		bts.add(9);
//		bts.add(3);
//		bts.add(10);
//		bts.inorder();
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(3);
		list.add(5);
		list.add(12);
		list.add(7);
		list.add(4);
		list.add(1);
		list.add(15);
		list.add(8);
		bts.add(list);
		bts.inorder();
		System.out.println("depth: "+bts.depth(15));
		System.out.println("depth: "+bts.depth(7));
		System.out.println("depth: "+bts.depth(8));
		System.out.println("size: "+bts.size());
		System.out.println("contains: "+bts.contains(12));
		System.out.println("findMax: "+bts.findMax());
		System.out.println("findMax: "+bts.findMin());
		System.out.println("height: "+bts.height());
		System.out.println("remove: "+bts.remove(4));
		System.out.println("remove: "+bts.remove(12));
		System.out.println("size: "+bts.size());
		System.out.println(bts.descendants(9));
		System.out.println(bts.ancestors(9));
		bts.inorder();
		
	}

}
