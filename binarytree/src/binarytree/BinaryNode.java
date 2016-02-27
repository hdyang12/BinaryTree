package binarytree;

public class BinaryNode<T> {

	public T data;	//数据域,存储数据元素
	public BinaryNode<T> left,right;	//链域,分别指向左、右孩子结点
	//构造结点,参数分别指定元素和左、右孩子结点
	public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	//构造指定值得叶子结点
	public BinaryNode(T data){
		this(data,null,null);
	}
	public BinaryNode(){
		this(null,null,null);
	}
	
}
