package tree; /**
 * @(#)BTree.java
 *
 *
 * @author
 * @version 1.00 2013/4/22
 */
import java.util.Scanner;

public class BTree {
	public BNode root;
    public BTree() {
    }

    public BNode createBTree(){
		char ch;
		BNode bt;
		System.out.println("�Ӽ���������һ���ַ�");
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		ch=s1.charAt(0);//�Ӽ���������һ���ַ�
		if (ch == '#') {
			return null;//�ո���Ϊ������־
		}
		else{
			bt= new BNode();//�����½��
			bt.data=ch;
			bt.lChild= createBTree();
			bt.rChild= createBTree();
			return (bt);
		}
    }

    public void preTravel(BNode t){
		if (t != null) {
			System.out.println(" "+t.data);
			preTravel(t.lChild);
			preTravel(t.rChild);
    	}
    }
    public void inTravel(BNode t){
		if (t != null) {
			inTravel(t.lChild);
			System.out.println(" "+t.data);
			inTravel(t.rChild);
    	}
    }
    public void postTravel(BNode t){
		if (t != null) {
			postTravel(t.lChild);
			postTravel(t.rChild);
			System.out.println(" "+t.data);
    	}
    }
    public void prenumber(BNode t){
    	int twocount=0;//�������ڵ���ӽڵ�
    	int onecount=0;//��һ���ڵ���ӽڵ�
    	int nocount=0;//Ҷ�ӽڵ�
    	BNode stack[]=new BNode [30];
    	char max=t.data;
    	char min=t.data;
    	int count=0;
    	int  top=0;
    	do {
    		while(t!=null){
    		System.out.println(" "+t.data);
    		if (t.data>max){
    			max=t.data;
    		}
    		if (t.data<min){
    			min=t.data;
    		}
    		
    		count++;
    		if ((t.lChild!=null)&&(t.rChild!=null)){
    			twocount++;
    		}
    		else
    			if(((t.lChild!=null)&&(t.rChild==null))||((t.rChild!=null)&&(t.lChild==null))){
    				onecount++;
    			}
    			else
    				if((t.rChild==null)&&(t.lChild==null)){
    					nocount++;
    				}
    		if (top==10){
    		
    			System.out.print("stack full");
    			return ;
    		            }
    		
    		stack[++top]=t;
    		
    		t=t.lChild;
    		}
    		if (top!=0){
    		t=stack[top--];
    		t=t.rChild;
    	}
    	}while (top!=0||t!=null);
    	System.out.println("the number of the node is: "+count);
    	System.out.println("the number of the one node is: "+onecount);
    	System.out.println("the number of the two node is: "+twocount);
    	System.out.println("the number of the no node is: "+nocount);
    	System.out.println("the MAX of tree is: "+max);
    	System.out.println("the MIN of tree is: "+min);
    }
	public static void main(String[] args){
		BTree tt =  new BTree();
		tt.root = tt.createBTree();
		
		

		System.out.println("Pre Order");
		tt.preTravel(tt.root);
		System.out.println("In Order");
		tt.inTravel(tt.root);
		System.out.println("Post Order");
		tt.postTravel(tt.root);
		System.out.println("Pre Order again");
		tt.prenumber(tt.root);
	}

}