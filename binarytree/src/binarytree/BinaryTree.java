package binarytree;

public class BinaryTree<T> {

	private int i = 0;
	public BinaryNode<T> root; // 根结点,结点结构为二叉链表

	public BinaryTree() {
		this.root = null;
	} // 构造空二叉树

	// 以先根和中根次序遍历序列构造二叉树
	public BinaryTree(T[] prelist, T[] inlist) {
		this.root = create(prelist, inlist, 0, 0, prelist.length);
	}

	// 标明空子树的先根序列构造一棵二叉树
	public BinaryTree(T[] prelist) {
		this.root = create(prelist);
	}

	/**
	 * 以先根和中根序列创建一棵子树，子树根结点值是prelist[preStart]，n指定子序列长度，返回所创建子树的根结点
	 * 
	 * @param prelist
	 * @param inlist
	 * @param preStart
	 * @param inStart
	 * @param n
	 * @return
	 */
	private BinaryNode<T> create(T[] prelist, T[] inlist, int preStart,
			int inStart, int n) {
		if (n <= 0)
			return null;
		T elem = prelist[preStart]; // 根结点值
		BinaryNode<T> p = new BinaryNode<T>(elem); // 创建叶子结点
		int i = 0;
		while (i < n && !elem.equals(inlist[inStart + i]))
			i++;
		p.left = create(prelist, inlist, preStart + 1, inStart, i); // 创建左子树
		p.right = create(prelist, inlist, preStart + i + 1, inStart + i + 1, n
				- 1 - i); // 创建右子树
		return p;
	}

	/**
	 * 以标明空子树的先根序列构造一棵子二叉树,子树的根值是prelist[i],返回所创建子树的根结点
	 * 
	 * @param prelist
	 * @return
	 */
	private BinaryNode<T> create(T[] prelist) {
		BinaryNode<T> p = null;
		if (i < prelist.length) {
			T elem = prelist[i];
			i++;
			if (elem != null) {
				p = new BinaryNode<T>(elem); // 创建叶子结点
				p.left = create(prelist); // 创建p的子左树
				p.right = create(prelist); // 创建p的右子树
			}
		}
		return p;
	}

	public boolean isEmpty() {
		return this.root == null;
	} // 判断二叉树是否空

	/**
	 * 先根次序遍历二叉树
	 */
	public void preOrder() {
		System.out.print("先根次序遍历二叉树:  ");
		preOrder(root); // 调用先根次序遍历二叉树的递归方法
		System.out.println();
	}

	/**
	 * 先根次序遍历以p结点为根的子二叉树,递归方法
	 * 
	 * @param p
	 */
	private void preOrder(BinaryNode<T> p) {
		if (p != null) {
			System.out.print(p.data.toString() + " "); // 访问当前结点
			preOrder(p.left); // 按先根次序遍历当前结点的左子树,递归调用
			preOrder(p.right); // 按先根次序遍历当前结点的右子树,递归调用
		}
	}

	/**
	 * 中根次序遍历二叉树
	 */
	public void inOrder() {
		System.out.print("中根次序遍历二叉树:  ");
		inOrder(root);
		System.out.println();
	}

	/**
	 * 中根次序遍历以p结点为根的子二叉树,递归方法
	 * 
	 * @param p
	 */
	private void inOrder(BinaryNode<T> p) {
		if (p != null) {
			inOrder(p.left); // 中跟次序遍历左子树,递归调用
			System.out.print(p.data.toString() + " ");
			inOrder(p.right); // 中跟次序遍历右子树,递归调用
		}
	}

	/**
	 * 后根次序遍历二叉树
	 */
	public void postOrder() {
		System.out.print("后根次序遍历二叉树:  ");
		postOrder(root);
		System.out.println();
	}

	/**
	 * 后根次序遍历以p结点为根的子二叉树,递归方法
	 * 
	 * @param p
	 */
	private void postOrder(BinaryNode<T> p) {
		if (p != null) {
			postOrder(p.left); // 后跟次序遍历左子树,递归调用
			postOrder(p.right); // 后跟次序遍历右子树,递归调用
			System.out.print(p.data.toString() + " ");
		}
	}

	/**
	 * 返回二叉树的结点个数
	 */
	public int count() {
		return count(root);
	}

	/**
	 * 返回以p结点为根的子树的结点个数
	 * 
	 * @param p
	 * @return
	 */
	private int count(BinaryNode<T> p) {
		if (p == null)
			return 0;
		return 1 + count(p.left) + count(p.right);
	}

	/**
	 * 返回二叉树的高度
	 */
	public int height() {
		return height(root);
	}

	private int height(BinaryNode<T> p) {
		if (p == null)
			return 0;
		int lh = height(p.left);
		int rh = height(p.right);
		return (lh >= rh) ? lh + 1 : rh + 1;
	}

	/**
	 * 查找并返回首次出现的关键字为key元素结点
	 */
	public BinaryNode<T> search(T key) {
		return search(root, key);
	}

	private BinaryNode<T> search(BinaryNode<T> p, T key) {
		if (p == null || key == null)
			return null;
		if (p.data.equals(key))
			return p;
		BinaryNode<T> find = search(p.left, key);
		if (find == null)
			find = search(p.right, key);
		return find;
	}

	/**
	 * 获得父母结点
	 */
	public BinaryNode<T> getParent(BinaryNode<T> node) {
		if (root == null || node == null || node == root)
			return null;
		return getParent(root, node);
	}

	private BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node) {
		if (p == null)
			return null;
		if (p.left == node || p.right == node)
			return p;
		BinaryNode<T> find = getParent(p.left, node);
		if (find == null)
			find = getParent(p.right, node);
		return find;
	}
}