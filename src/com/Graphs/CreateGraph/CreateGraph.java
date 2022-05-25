package com.Graphs.CreateGraph;

import java.util.ArrayList;

public class CreateGraph {
	
	
	static class Graph
	{
		ArrayList<ArrayList<Integer>>adjList;
		int v;
		
		public Graph(int v)
		{
			this.v=v;
			adjList=new ArrayList<>();
			for(int i=0;i<v;i++)
			{
				adjList.add(new ArrayList<Integer>());
			}
		}
	}
	
	
	public static void addEdge(Graph g,int sou,int dest)
	{
		g.adjList.get(sou).add(dest);
		g.adjList.get(dest).add(sou);
	}
	
	public static void printGraph(Graph g)
	{
		for(int i=0;i<g.adjList.size();i++)
		{
			System.out.print("Source: "+i);
			for(int j=0;j<g.adjList.get(i).size();j++)
			{
				System.out.print(" -> "+g.adjList.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Graph adj=new Graph(5);
		addEdge(adj, 0, 1); 
        addEdge(adj, 0, 4); 
        addEdge(adj, 1, 2); 
        addEdge(adj, 1, 3); 
        addEdge(adj, 1, 4); 
        addEdge(adj, 2, 3); 
        addEdge(adj, 3, 4); 
        
        printGraph(adj);
	}
	
	

}
