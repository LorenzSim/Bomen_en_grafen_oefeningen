package domain;

import java.util.ArrayList;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;

	public BinaryTree(E data){
		this(data,null,null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	public void printPreorder(){
		System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.printPreorder();
		if (this.rightTree != null) this.rightTree.printPreorder();
	}
	public void printInorder(){
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printPostorder(){
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public int countNodes(){
		int result = 0;

		if (leftTree != null) result += leftTree.countNodes();
		if (rightTree != null) result += rightTree.countNodes();

		return 1 + result;
	}

	public int getDepth(){
		int left = 0, right = 0;

		if (leftTree != null) left = leftTree.getDepth();
		if (rightTree != null) right = rightTree.getDepth();

		return Math.max(1 + left, 1 + right);
	}

	public boolean isLeaf(){
		return leftTree == null && rightTree == null;
	}

	public ArrayList<E> getDataLeaves(){
		ArrayList<E> result = new ArrayList<>() {{ add(data); }};

		if (leftTree != null) result.addAll(leftTree.getDataLeaves());
		if (rightTree != null) result.addAll(rightTree.getDataLeaves());

		return result;
	}
	public int countLeaves(){
		if (isLeaf()) return 1;

		int left = 0, right = 0;
		if (leftTree != null) left = leftTree.countLeaves();
		if (rightTree != null) right = rightTree.countLeaves();

		return left + right;
	}

	public boolean contains(E node){
		return data.equals(node) || leftTree != null && leftTree.contains(node) || rightTree != null && rightTree.contains(node);
	}
	public int count(E data){
		int result = 0;
		if (this.data == data) result = 1;
		if (isLeaf()) return result;

		if (leftTree != null) result += leftTree.count(data);
		if (rightTree != null) result += rightTree.count(data);

		return result;
	}

	public ArrayList<E> getNodesAtDistance(int k){
		ArrayList<E> result = new ArrayList<>();
		if (k == 0) result.add(data);
		else {
			if (leftTree != null) result.addAll(leftTree.getNodesAtDistance(k - 1));
			if (rightTree != null) result.addAll(rightTree.getNodesAtDistance(k - 1));
		}
		return result;
	}

	public BinaryTree<E> deelZonder(E wortelInfo){
		if (!contains(wortelInfo)) return null;
		BinaryTree<E> result = new BinaryTree<>(this.data);

		if (leftTree != null && leftTree.data != wortelInfo) result.leftTree = leftTree.deelZonder(wortelInfo);
		if (rightTree != null && rightTree.data != wortelInfo) result.rightTree = rightTree.deelZonder(wortelInfo);
		return result;
	}

	public boolean isStrikt(){
		if (isLeaf()) return true;
		if (leftTree == null || rightTree == null) return false;
		return leftTree.isStrikt() && rightTree.isStrikt();
	}
}