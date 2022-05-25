package com.Graphs.BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {

	static class Graph {
		LinkedList<Integer> adjList[];
		int v;

		@SuppressWarnings("unchecked")
		public Graph(int v) {
			this.v = v;
			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++) {
				adjList[i] = new LinkedList<>();
			}
		}
	}

	public static void addEdge(Graph g, int sou, int dest) {
		g.adjList[sou].add(dest);
	}

	public static void printGraph(Graph g) {
		for (int i = 0; i < g.adjList.length; i++) {
			System.out.print("Source: " + i);
			Iterator<Integer> iter = g.adjList[i].listIterator();
			while (iter.hasNext()) {
				System.out.print(" -> " + iter.next());
			}
			System.out.println();
		}
	}

	public static void BFS(Graph g, int sou) {
		boolean visited[] = new boolean[g.adjList.length];

		Queue<Integer> q = new LinkedList<>();
		q.add(sou);
		visited[sou] = true;
		// System.out.print(sou);

		while (!q.isEmpty()) {
			sou = q.poll();
			System.out.print(sou + " ");

			Iterator<Integer> iter = g.adjList[sou].iterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}

		}
	}

	public static void main(String[] args) {

		Graph g = new Graph(4);

		addEdge(g, 0, 1);
		addEdge(g, 0, 2);
		addEdge(g, 1, 2);
		addEdge(g, 2, 0);
		addEdge(g, 2, 3);
		addEdge(g, 3, 3);
		
		System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

		BFS(g, 2);
	}

}
