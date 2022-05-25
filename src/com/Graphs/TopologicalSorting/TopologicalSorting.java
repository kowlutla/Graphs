package com.Graphs.TopologicalSorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {

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
	
	public static void topologicalSort(Graph g)
	{
		boolean visited[]=new boolean[g.getNoOfVertices()];
		Stack<Integer>stack=new Stack<Integer>();
		for(int i=0;i<g.getNoOfVertices();i++)
		{
			if(!visited[i])
			{
				topologicalSort(g,i,stack,visited);
			}
		}
		
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}
	
	private static void topologicalSort(Graph g,int i, Stack<Integer> stack, boolean[] visited) {
		
		visited[i]=true;
		
		Iterator<Integer>iter=g.adjList[i].iterator();
		while(iter.hasNext())
		{
			Integer temp=iter.next();
			if(!visited[temp])
				topologicalSort(g,temp,stack,visited);
		}
		
		stack.push(i);
		
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(6); 
        addEdge(g,5, 2); 
        addEdge(g,5, 0); 
        addEdge(g,4, 0); 
        addEdge(g,4, 1); 
        addEdge(g,2, 3); 
        addEdge(g,3, 1); 

        System.out.println("Following is a Topological "
                + "sort of the given graph"); 
// Function Call 
        topologicalSort(g); 
	}

}
