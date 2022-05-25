package com.Graphs.wordLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

	static class Node
	{
		int data;
		Node left,right;
		public Node(int data)
		{
			this.data=data;
			this.left=this.right=null;
		}
		
		public String toString()
		{
			return data+" ";
		}
	}
	
	public Node createNode(int data)
	{
		Node newNode=new Node(data);
		return newNode;
	}
	
	public int getHeight(Node root) {
		
		if(root==null)
			return 0;
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		
		if(left>right)
			return left+1;
		return right+1;
	}
	
	
	public int nodeCount(Node root) {
		if(root==null)
			return 0;
		return 1+nodeCount(root.left)+nodeCount(root.right);
	}
	
	public int nodeCount1(Node root)
	{
		if(root==null)
			return 0;
		
		Queue<Node>q=new LinkedList<>();
		int count=0;
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.remove();
			count++;
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		return count;
	}
	
	public int leafCount(Node root)
	{
		if(root==null)
				return 0;
		if(root.left==null && root.right==null)
			return 1;
		return leafCount(root.left)+leafCount(root.right);
	}
	
	public void leafNodes(Node root)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
			System.out.print(root);
		leafNodes(root.left);
		leafNodes(root.right);
	}
	
	public int nonLeafCount(Node root)
	{
		if(root==null)
			return 0;
		int count=0;
		if(root.left!=null || root.right!=null)
			count=1;
		count=count+nonLeafCount(root.left)+nonLeafCount(root.right);
		return count;
	}
	
	public void nonLeafNodes(Node root)
	{
		if(root==null)
			return ;
		if(root.left!=null || root.right!=null)
			System.out.print(root);
		nonLeafNodes(root.left);nonLeafNodes(root.right);
	}
	
	public int countFullNodes(Node root)
	{
		if(root==null)
			return 0;
		int count=0;
		if(root.left!=null && root.right!=null)
			count=1;
		count+=countFullNodes(root.left)+countFullNodes(root.right);
		return count;
	}
	
	public void fullNodes(Node root)
	{
		if(root==null)
			return;
		if(root.left!=null && root.right!=null)
			System.out.print(root);
		fullNodes(root.left);
		fullNodes(root.right);
	}
	
	public void preOrder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root)
	{
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root);
		inOrder(root.right);
	}
	
	public void postOrder(Node root)
	{
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root);
	}
	
	
	public void levelOrder(Node root)
	{
		int height=getHeight(root);
		for(int i=1;i<=height;i++)
		{
			printLevel(root,i);
			System.out.println();
		}
	}
	
	public void reverseLevelOrder(Node root)
	{
		if(root==null)
			return;
		int height=getHeight(root);
		for(int i=height;i>=1;i--)
		{
			printReverseLevel(root,i);
			System.out.println();
		}
	}
	private void printLevel(Node root,int level)
	{
		if(root==null)
			return;
		if(level==1)
			System.out.print(root);
		printLevel(root.left,level-1);
		printLevel(root.right,level-1);
	}
	
	private void printReverseLevel(Node root,int level)
	{
		if(root==null)
			return;
		if(level==1)
			System.out.print(root);
		printReverseLevel(root.right,level-1);
		printReverseLevel(root.left, level-1);
	}
	
	public void postOrder1(Node root) {
		
		if(root==null)
			return;
		Stack<Node>stack1=new Stack<>();
		Stack<Node>stack2=new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty())
		{
			Node temp=stack1.pop();
			if(temp.left!=null)
				stack1.push(temp.left);
			if(temp.right!=null)
				stack1.push(temp.right);
			stack2.push(temp);
		}
		
		while(!stack2.isEmpty())
		{
			System.out.print(stack2.pop());
		}
		
	}

	public void inOrder1(Node root) {

		if(root==null)
			return;
		Stack<Node>stack=new Stack<>();
		Node temp=root;
		while(!stack.isEmpty() || temp!=null)
		{
			if(temp!=null)
			{
				stack.push(temp);
				temp=temp.left;
			}
			else
			{
				temp=stack.pop();
				System.out.print(temp);
				temp=temp.right;
			}
		}
	}

	public void levelOrder1(Node root) {
		
		if(root==null)
			return;
		Queue<Node>q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp);
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		
	}

	public void reverseLevelOrder1(Node root) {

		if(root==null)
			return;
		Queue<Node>q=new LinkedList<>();
		Stack<Node>stack=new Stack<>();
		
		q.add(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			stack.push(temp);
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}

	public void preOrder1(Node root) {

		if(root==null)
			return;
		Stack<Node>stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			Node temp=stack.pop();
			System.out.print(temp);
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}
	}
	
	public void verticalOrderTraversal(Node root)
	{
		if(root==null)
			return;
		
		TreeMap<Integer,ArrayList<Node>>map=new TreeMap<>();
		verticalOrderTraversal(root,map,0);
		
		for(Map.Entry<Integer,ArrayList<Node>>e:map.entrySet())
		{
			System.out.println(e.getKey()+"::>\t"+e.getValue());
		}
	}

	private void verticalOrderTraversal(Node root, TreeMap<Integer, ArrayList<Node>> map, int level) {
		
		if(root==null)
			return;
		ArrayList<Node>list=map.get(level);
		if(list==null)
		{
			list=new ArrayList<>();
			list.add(root);
		}
		else
		{
			list.add(root);
		}
		
		map.put(level, list);
		verticalOrderTraversal(root.left, map, level-1);
		verticalOrderTraversal(root.right, map, level+1);	
	}
	
	public int sumOfAllNodes(Node root)
	{
		if(root==null)
			return 0;
		return root.data+sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
	}

	public int difOfEvenOddLevels(Node root)
	{
		if(root==null)
			return 0;
		
		return root.data-(difOfEvenOddLevels(root.left)+difOfEvenOddLevels(root.right));
	}
	
	public int getLevel(Node root,int data)
	{
		return getLevel(root,data,0);
	}
	
	private int getLevel(Node root,int data,int level)
	{
		if(root==null)
			return -1;
		if(root.data==data)
			return level;
		int result=getLevel(root.left,data,level+1);
		if(result!=-1)
			return result;
		result=getLevel(root.right,data,level+1);
		return result;
	}
	
	public void leftView(Node root)
	{
		if(root==null)
			return;
		
		Queue<Node>q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			int size=q.size();
			for(int i=1;i<=size;i++)
			{
				Node temp=q.poll();
				if(i==1)
					System.out.println(temp);
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
	public void rightView(Node root)
	{
		
		if(root==null)
			return;
		Queue<Node>q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			int size=q.size();
			for(int i=1;i<=size;i++)
			{
				Node temp=q.poll();
				if(i==size)
					System.out.println(temp);
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
	public void leftView1(Node root)
	{
		leftView1(root,0);
	}
	int maxLevel1=0;
	private void leftView1(Node root,int level)
	{
		if(root==null)
			return;
		if(level==maxLevel1)
		{
			System.out.println(root);
			maxLevel1++;
		}
		
		leftView1(root.left,level+1);
		leftView1(root.right,level+1);
	}
	
	
	public void topView(Node root)
	{
		if(root==null)
			return;
		
		class QueueObj
		{
			Node node;
			int hd;
			
			public QueueObj(Node node,int hd)
			{
				this.hd=hd;
				this.node=node;
			}
		}
		
		Map<Integer,Node>map=new TreeMap<>();
		Queue<QueueObj>q=new LinkedList<>();
		q.add(new QueueObj(root,0));
		
		while(!q.isEmpty())
		{
			QueueObj temp=q.poll();
			int hd=temp.hd;
			Node node=temp.node;
			
			if(!map.containsKey(hd))
			{
				map.put(hd,node);
			}
			
			if(node.left!=null)
				q.add(new QueueObj(node.left,hd-1));
			if(node.right!=null)
				q.add(new QueueObj(node.right,hd+1));
		}
		
		for(Map.Entry<Integer, Node>e:map.entrySet())
		{
			System.out.println(e.getValue());
		}
	}
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		Node root=tree.createNode(10);
		root.left=tree.createNode(20);
		root.right=tree.createNode(30);
		root.left.left=tree.createNode(40);
		root.left.right=tree.createNode(50);
		root.right.left=tree.createNode(60);
		root.right.right=tree.createNode(70);
		root.right.left.right=tree.createNode(80);
		root.right.right.right=tree.createNode(90);
		root.right.right.right.right=tree.createNode(100);
		
		System.out.println("Height of tree: "+tree.getHeight(root));
		System.out.println();
		
		System.out.print("No of Nodes in tree 1: ");
		System.out.println(tree.nodeCount(root));
		System.out.println();
		
		System.out.print("No of Nodes in tree 2: ");
		System.out.println(tree.nodeCount1(root));
		System.out.println();
		
		System.out.println("Count of Leaf Nodes: ");
		System.out.println(tree.leafCount(root));
		System.out.println();
		
		System.out.println("Leaf Nodes of Binary Tree: ");
		tree.leafNodes(root);
		System.out.println("\n");
		
		System.out.println("Count of Non-leaf Nodes: ");
		System.out.println(tree.nonLeafCount(root));
		System.out.println();

		System.out.println("Non-Leaf Nodes in Binary Tree: ");
		tree.nonLeafNodes(root);
		System.out.println("\n");
		
		System.out.println("Count of full nodes in binary tree: ");
		System.out.println(tree.countFullNodes(root));
		System.out.println();

		System.out.println("Full Nodes in Binary tree: :");
		tree.fullNodes(root);
		System.out.println("\n");
		
		System.out.println("Pre Order Traversal 1: ");
		tree.preOrder(root);
		System.out.println("\n");


		System.out.println("InOrder Traversal 1: ");
		tree.inOrder(root);
		System.out.println("\n");

		System.out.println("Post Order Traversal 1: ");
		tree.postOrder1(root);
		System.out.println("\n");
		
		System.out.println("Level Order Traversal : ");
		tree.levelOrder(root);
		System.out.println("\n");
		
		System.out.println("Reverse Level Order Traversal: ");
		tree.reverseLevelOrder(root);
		System.out.println("\n");
		
		System.out.println("Pre Order Traversal 2 : ");
		tree.preOrder1(root);
		System.out.println("\n");

		System.out.println("InOrder Traversal 2: ");
		tree.inOrder1(root);
		System.out.println("\n");

		System.out.println("Post Order Traversal 2: ");
		tree.postOrder1(root);
		System.out.println("\n");

		System.out.println("Level Order 2: ");
		tree.levelOrder1(root);
		System.out.println("\n");

		System.out.println("Reverse level Order 2: ");
		tree.reverseLevelOrder1(root);
		System.out.println("\n");
		
		System.out.println("vertical Order traversal: ");
		tree.verticalOrderTraversal(root);
		System.out.println("\n");
		
		System.out.println("Sum of All Nodes: ");
		int sum=tree.sumOfAllNodes(root);
		System.out.println(sum);
		System.out.println();
		
		System.out.println("Difference of Even and Odd levels: ");
		int dif=tree.difOfEvenOddLevels(root);
		System.out.println(dif);
		System.out.println();

		System.out.println("Level of a node 80 : ");
		int level=tree.getLevel(root,80);
		System.out.println(level);
		System.out.println();
		
		System.out.println("Left View Of Tree: ");
		tree.leftView1(root);
		System.out.println();
		
		System.out.println("Right View Of Tree: ");
		tree.rightView(root);
		System.out.println();
		
		System.out.println("Top View Of Tree: ");
		tree.topView(root);
		System.out.println();

	}

	
}
