package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if (this.data.compareTo(data) == 0) return true;

		if(data.compareTo(this.data) < 0) return leftTree == null ? false : leftTree.lookup(data);
		return rightTree == null ? return false : rightTree.lookup(data);
	}

	public boolean addNode(E data) {
		if (this.data.compareTo(data) == 0) return false;

		if (data.compareTo(this.data) < 0) {
			if(leftTree == null){
				leftTree = new BinarySearchTree<>(data);
				return true;
			}
			else return leftTree.addNode(data);
		}

		if (rightTree == null){
			rightTree = new BinarySearchTree<>(data);
			return true;
		}
		return rightTree.addNode(data);
	}

	public boolean isLeaf(){
		return leftTree == null && rightTree == null;
	}

	public boolean removeNode(E data){
		if (this.data.compareTo(data) == 0) {

			if (this.isLeaf()){
				this.data = null;
				return true;
			}
			if (leftTree != null){
				E gl = leftTree.searchGreatest();
				this.data = gl;
				removeNode(gl);
				return true;
			}

			E kr = rightTree.searchSmallest();
			this.data = kr;
			rightTree.removeNode(kr);
			return true;
		}

		if (data.compareTo(this.data) < 0){
			if (leftTree == null ) return false;
			return leftTree.removeNode(data);
		}
		if (rightTree == null){
			return false;
		}
		return rightTree.removeNode(data);
	}

	public E searchSmallest(){
		if (leftTree == null) return data;
		return leftTree.searchSmallest();
	}

	public E searchGreatest(){
		if (rightTree == null) return data;
		return rightTree.searchGreatest();
	}

	public void cleanUp(){
		if (this.leftTree != null){
			if (this.leftTree.data == null) {
				this.leftTree = null;
			}
			else this.leftTree.cleanUp();
		}
		if (this.rightTree != null){
			if (this.rightTree.data == null){
				this.rightTree = null;
			}
			else this.rightTree.cleanUp();
		}
	}

	public ArrayList<E> getPath(E data){
		if (!lookup(data)) throw new IllegalArgumentException("The data does not exist in the tree.");

		ArrayList<E> path = new ArrayList<>();
		path.add(this.data);
		if (data.compareTo(this.data) == 0) return path;

		if (data.compareTo(this.data) < 0) path.addAll(leftTree.getPath(data));
		else if (data.compareTo(this.data) > 0) path.addAll(rightTree.getPath(data));

		return path;
	}

	public int count(E data){
		int result = 0;
		if (data.compareTo(data) == 0) result++;
		if (isLeaf()) return result;

		if (leftTree != null) result += leftTree.count(data);
		if (rightTree != null) result += rightTree.count(data);

		return result;
	}

	public ArrayList<E> geefKnopenBinnenInterval(E min, E max){
		ArrayList<E> result = new ArrayList<>();
		if (data.compareTo(min) >= 0 && data.compareTo(max) <= 0){
			result.add(data);
		}
		if (leftTree != null){
			result.addAll(leftTree.geefKnopenBinnenInterval(min, max));

		}
		if (rightTree != null){
			result.addAll(rightTree.geefKnopenBinnenInterval(min, max));
		}
		Collections.sort(result);
		return result;
	}
}


