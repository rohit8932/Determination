package PracticeRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	List<List<Integer>> adjList = new ArrayList<>();
	//this method is also called transpose of matrix
	//time- we are only dealing with one side of diagonal (including diagonal), O(n^2/2) space-O(1)
	public void reverseEdge(int[][] mat) {
		int row = mat.length;
		for(int i = 0; i < row; i++) {
			for(int j = i; j < row; j ++) {
				if(i != j) {
					int temp = mat[i][j];
					mat[i][j] = mat[j][i];
					mat[j][i] = temp;
				}
			}
		}
	}
	
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}
	}
	
	Graph(List<Edge> edges, int V){
		for(int i = 0; i < V; i++) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
		}
	}
	
	//time- O(V+E) here we are traveling the adjList which is made up of V+E space- (V+E) we creating the same 
																					//adjLst with some difference 
	public void reverseAdjList(Graph g, int V) {
		List<List<Integer>> newAdjList = new ArrayList<List<Integer>>();
		for(int i = 0; i < V; i ++) {
			newAdjList.add(i, new ArrayList<Integer>());
		}
		
		for(int i = 0; i < g.adjList.size(); i++) {
			for(int j = 0; j < g.adjList.get(i).size(); j++) {
				if(g.adjList.get(i).get(j) != null) {
					newAdjList.get(g.adjList.get(i).get(j)).add(i);
				}
			}
		}
		for(int i = 0; i < newAdjList.size(); i++) {
			System.out.print(i);
			for(int j = 0; j < newAdjList.get(i).size(); j++) {
				System.out.print("--> " + newAdjList.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] adjMat = {{0, 1, 0, 0, 0, 0, 0, 0},
				 {1, 0, 0, 1, 0, 0, 0, 0},
				 {0, 1, 0, 1, 0, 0, 0, 0},
				 {0, 0, 1, 0, 1, 0, 0, 0},
				 {0, 0, 1, 0, 1, 0, 0, 0},
				 {0, 0, 0, 1, 0, 1, 0, 0},
				 {0, 0, 0, 1, 0, 1, 1, 1},
				 {0, 0, 0, 0, 0, 0, 0, 0}};
		
		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(0, 1), new Graph.Edge(1, 2),
											   new Graph.Edge(2, 3));
		
		for(int i = 0; i < adjMat.length; i++) {
			for(int j = 0; j <adjMat.length; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
		Graph g = new Graph(edges, 4);
		g.reverseEdge(adjMat);
		System.out.println();
		for(int i = 0; i < adjMat.length; i++) {
			for(int j = 0; j <adjMat.length; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 0; i < g.adjList.size(); i++) {
			System.out.print(i);
			for(int j = 0; j < g.adjList.get(i).size(); j++) {
				System.out.print("--> " + g.adjList.get(i).get(j));
			}
			System.out.println();
		}
		
		g.reverseAdjList(g, 4);
	}
}
