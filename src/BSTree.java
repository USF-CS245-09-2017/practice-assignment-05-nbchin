
public class BSTree {
	
	private BSTNode root;
	
	public void insert(String str) {
		root = insert(str, root);
	}
	
	protected BSTNode insert(String str, BSTNode node){
		if(node == null){
			return new BSTNode(str);
		}
		if(str.compareTo(node.data) < 0){
			node.left = insert(str, node.left);
		} else {
			node.right = insert(str, node.right);
		}
		return node;
	}
	
	private String toStringInOrder(BSTNode node){
		if(node == null){
			return "";
		}
		return (toStringInOrder(node.left) + node.data + " " + toStringInOrder(node.right));
	}
	
	public String toStringInOrder(){
		return toStringInOrder(root).trim();
	}

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public boolean find(String str) {
		// TODO Auto-generated method stub
		return find(root, str);
	}
	
	private boolean find(BSTNode node, String str){
		if(node == null)
			return false;
		if(str.compareTo(node.data) == 0){
			return true;
		} else if (str.compareTo(node.data) < 0){
			return find(node.left, str);
		} else {
			return find(node.right, str);
		}
	}

	public void delete(String string) {
		// TODO Auto-generated method stub
		root = delete(root, string);
	}
	
	private BSTNode delete(BSTNode node, String str){
		if(node == null){
			return null;
		}
		if(node.data.compareTo(str) == 0){
			if(node.left == null){
				return node.right;
			} else if (node.right == null){
				return node.left;
			}
			if(node.right.left == null){
				node.data = node.right.data;
				node.right = node.right.right;
				return node;
			} else {
				node.data = removeSmallest(node.right);
				return node;
			}
		}
		return node;
	}
	
	private String removeSmallest(BSTNode node){
		if(node.left == null){
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		return removeSmallest(node.left);
	}

	public Object toStringPreOrder() {
		// TODO Auto-generated method stub
		return toStringPreOrder(root).trim();
	}
	
	private String toStringPreOrder(BSTNode node){
		if(node == null){
			return "";
		}
		return (node.data + " " + toStringPreOrder(node.left)  + toStringPreOrder(node.right));
	}

	

}
