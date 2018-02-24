package eg.edu.alexu.csd.filestructure.sort.cs09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import eg.edu.alexu.csd.filestructure.sort.IHeap;
import eg.edu.alexu.csd.filestructure.sort.INode;

/**
 * @author ahmednasser
 *
 * @param <T>
 */
public class MyHeap<T extends Comparable<T>> implements IHeap<T> {
	private ArrayList<Node<T>> tree = new ArrayList<>();
	private int size = 0;
	private final static int ROOT_INDEX = 0;
	private final static int FIRST_INDEX = 0;
	private final static int SECOND_INDEX = 0;

	@Override
	public INode<T> getRoot() {
		// TODO Auto-generated method stub
		if (size > ROOT_INDEX)
			return tree.get(ROOT_INDEX);
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (size > ROOT_INDEX)
			return size;
		throw null;
	}

	@Override
	public void heapify(INode<T> node) {
		// TODO Auto-generated method stub
		// node = tree.get(1);
		int nodeIndex = ((Node<T>) node).getIndex();
		int leftIndex = getLeftIndex(nodeIndex);
		int rightIndex = getRightIndex(nodeIndex);
		int max = ROOT_INDEX;
		if ((leftIndex < size) && (tree.get(leftIndex).getValue().compareTo(node.getValue()) > ROOT_INDEX)) {
			max = leftIndex;
		} else {
			max = ((Node<T>) node).getIndex();
		}

		if ((rightIndex < size) && (tree.get(rightIndex).getValue().compareTo(tree.get(max).getValue()) > ROOT_INDEX)) {
			max = rightIndex;
		}
		if (max != nodeIndex) {
			Collections.swap(tree, nodeIndex, max);
			buildHeap();
			heapify(tree.get(max));
		}

	}

	@Override
	public T extract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		if (element != null) {
			Node<T> temp = new Node<>();
			temp.setValue(element);
			temp.setIndex(size);
			tree.add(temp);
			size++;
			buildHeap();
		} else {
			throw null;
		}

	}

	@Override
	public void build(Collection<T> unordered) {
		// TODO Auto-generated method stub

	}

	private int getLeftIndex(int index) {
		return (index * SECOND_INDEX) + FIRST_INDEX;
	}

	private int getRightIndex(int index) {
		return (index * SECOND_INDEX) + SECOND_INDEX;

	}

	private int getParentIndex(int index) {
		return ((index - FIRST_INDEX) / SECOND_INDEX);
	}

	private void buildHeap() {
		for (int i = 0; i < size(); i++) {
			if ((getParentIndex(i) >= 0) && (getParentIndex(i) < size())) {
				tree.get(i).setParent(tree.get(getParentIndex(i)));
			}
			if ((getRightIndex(i) >= 0) && (getRightIndex(i) < size())) {
				tree.get(i).setRightChild(tree.get(getRightIndex(i)));
			}
			if ((getLeftIndex(i) >= 0) && (getLeftIndex(i) < size())) {
				tree.get(i).setLeftChild(tree.get(getLeftIndex(i)));
			}
			tree.get(i).setIndex(i);

		}
	}

	public void print() {
		for (int i = 0; i < tree.size(); i++) {
			System.out.print(tree.get(i).getValue() + " ");
		}
		System.out.println();
		// System.out.println(getRoot().getLeftChild().getValue()+" ");
		// System.out.println(getRoot().getLeftChild().getRightChild().getValue()+" ");
		// System.out.println(getRoot().getLeftChild().getRightChild().getLeftChild().getValue()+"
		// ");

	}

}
