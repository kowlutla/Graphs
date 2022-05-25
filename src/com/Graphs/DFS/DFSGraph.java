package com.Graphs.DFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSGraph {

	static class Graph
	{
		private int v;
		LinkedList<Integer> adjList[];
		
		public Graph(int v)
		{
			this.v=v;
			adjList=new LinkedList[v];
			
			for(int i=0;i<v;i++)
				adjList[i]=new LinkedList<>();
		}

		public int getNoOfVertices() {
			return v;
		}
		
	}
	
	public static void addEdge(Graph g,int s,int d)
	{
		g.adjList[s].add(d);
	}
	
	public static void DFS(Graph g,int s)
	{
		boolean visited[]=new boolean[g.getNoOfVertices()];
		Stack<Integer>stack=new Stack<Integer>();
		visited[s]=true;
		stack.push(s);
		while(!stack.isEmpty())
		{
			s=stack.pop();
			System.out.print(s+" ");
			Iterator<Integer>iter=g.adjList[s].iterator();	
			while(iter.hasNext())
			{
				int node=iter.next();
				if(!visited[node])
				{
					stack.push(node);
					visited[node]=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {

		Graph g = new Graph(4);
		 
        addEdge(g,0, 1);
        addEdge(g,0, 2);
        addEdge(g,1, 2);
        addEdge(g,2, 0);
        addEdge(g,2, 3);
        addEdge(g,3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        DFS(g,2);
	}

}
