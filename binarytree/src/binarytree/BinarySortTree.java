package binarytree;

public class BinarySortTree<T extends Comparable<T>> extends BinaryTree<T> {

	// 构造空二叉排序树
	public BinarySortTree() {
		super();
	} // 调用父类的默认构造方法

	// 将values数组元素依次插入构造一棵二叉排序树
	public BinarySortTree(T[] values) {
		super();
		for (int i = 0; i < values.length; i++)
			this.insert(values[i]); // 将元素插入到当前的二叉排序树中
	}

	//查找并返回首次出现的关键字为key元素结点,若查找不成功,则返回null,非递归算法
	public BinaryNode<T> search(T key) {
		if (key == null)
			return null;
		BinaryNode<T> p = this.root;
		while (p != null && p.data.compareTo(key) != 0)
			if (p.data.compareTo(key) > 0) // 若key较小
				p = p.left; // 进入左子树
			else
				p = p.right; // 进入右子树
		return p;
	}

	// 插入元素x结点,不插入关键字重复元素和空对象
	public void insert(T x) {
		if (x == null)
			return; // 不能插入空对象
		if (root == null)
			root = new BinaryNode<T>(x); // 建立根结点
		else { // 插入x到以root为根的二叉排序树中
			BinaryNode<T> p = this.root, parent = null;
			while (p != null) {
				parent = p;
				if (x.compareTo(p.data) == 0)
					return; // 不插入关键字重复的元素
				if (x.compareTo(p.data) < 0)
					p = p.left;
				else
					p = p.right;
			}
			p = new BinaryNode<T>(x); // 建立叶子结点p
			if (x.compareTo(parent.data) < 0)
				parent.left = p; // p作为parent的左孩子
			else
				parent.right = p; // p作为parent的右孩子
		}
	}
	
	//删除元素为x的结点,返回删除结点,若没删除,返回null
	public BinaryNode<T> remove(T x){
		if(root == null || x == null)
			return null;
		return remove(x,root,null);	//在以root为根的二叉排序树中删除值为x的结点
	}

	//在以p为根的子树中删除元素为x的结点,parent是p的父母结点,返回删除结点,递归算法
	private BinaryNode<T> remove(T x, BinaryNode<T> p, BinaryNode<T> parent) {
		if(p == null)
			return null;
		if(x.compareTo(p.data)<0)
			return remove(x,p.left,p);	//在p的左子树中删除x,递归调用
		if(x.compareTo(p.data)>0)
			return remove(x,p.right,p);	//在p的右子树中删除x,递归调用
		if(p.left!=null && p.right!= null){
			BinaryNode<T> insucc = p.right;	//寻找p在中根次序下的后继结点insucc
			while(insucc.left!= null)
				insucc = insucc.left;
			p.data = insucc.data;	//以后继结点值替换
			return remove(p.data,p.right,p);
		}
		if(parent==null){	//p是一度或叶子结点,删除根结点,即p==root
			if(p.left!=null)
				root = p.left;
			else root = p.right;
			return p;	//返回删除结点p
		}
		if(p == parent.left)	//p是1度或叶子结点,p是parent的左孩子
			if(p.left!=null)
				parent.left = p.left;	//以p的左子树填补
			else parent.left = p.right;
		else		//p是parent的右孩子
			if(p.left!=null)	
				parent.right=p.left;
			else parent.right=p.right;
		return p;
	}
}
