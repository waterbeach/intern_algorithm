package tree;

/**
 * @(#)BNode.java
 *
 *
 * @author
 * @version 1.00 2013/4/22
 */


public class BNode {
	public char data;
	public BNode lChild;
	public BNode rChild;

    public BNode() {
    }
	public BNode(char data){
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}
	public BNode(char data,BNode l,BNode r){
		this.data = data;
		this.lChild = l;
		this.rChild = r;
	}
}