package binarytree;

import org.junit.Test;


public class BinaryTree_make {

	public BinaryTree<String> make(){
		BinaryTree<String> bitree = new BinaryTree<String>();
		BinaryNode<String> child_b,child_c,child_d;
		child_d = new BinaryNode<String>("D",new BinaryNode<String>("H"),null);
		child_b = new BinaryNode<String>("B",child_d,new BinaryNode<String>("E"));
		child_c = new BinaryNode<String>("C",new BinaryNode<String>("F"),new BinaryNode<String>("G"));
		bitree.root = new BinaryNode<String>("A",child_b,child_c);
		return bitree;
	}
	
	/**
	 * 遍历二叉树
	 */
	@Test
	public void foreach(){
		BinaryTree<String> bitree = make();
		bitree.preOrder();	//先根次序遍历二叉树
		bitree.inOrder();	//中根次序遍历二叉树
		bitree.postOrder();	//后根次序遍历二叉树
	}
	
	/**
	 * 构造二叉树
	 */
	@Test
	public void createTree(){
		String[] prelist = {"A","B","D","G","C","E","F","H"};	//先根序列
		String[] inlist = {"D","G","B","A","E","C","H","F"};	//中根序列
		BinaryTree<String> bitree = new BinaryTree<String>(prelist,inlist);
		bitree.preOrder();
		bitree.inOrder();
	}
}
