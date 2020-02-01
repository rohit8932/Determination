package PracticeRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph2 {
	List<List<Integer>> adjList= new ArrayList<>();
	
	static class Edge {
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}
	}
	
	static class Cell{
		int x, y;
		Cell(int r, int c){
			this.x = r;
			this.y = c;
		}
	}
	
	public Graph2(List<Edge> edges, int V) {
		for(int i = 0; i < V; i++){
			adjList.add(i, new ArrayList<Integer>());
		}
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
//			adjList.get(e.destn).add(e.src); //just to make undirected graph
		}
	}
	public Graph2() {
		System.out.println("No AdjList!");
	}
	
	public void dfs(Graph2 graph, int start) {
		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		boolean[] visited = new boolean[graph.adjList.size()];
		visited[start] = true;
		while(!stack.empty()) {
			int temp = stack.pop();
			System.out.print(temp + " ");
			for(int v : graph.adjList.get(temp)) {
				if(visited[v] == false) {
					stack.add(v);
					visited[v] = true;
				}
			}
		}
	}
	
	public void dfs_recursive(Graph2 graph, int v, boolean[] visited) {
		if(visited[v] == false) {
			System.out.print(v + " ");
			visited[v] = true;
			for(int vertex : graph.adjList.get(v)) {
				dfs_recursive(graph, vertex, visited);
			}
		}
	}
	
	public void bfs(Graph2 graph, int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		boolean[] visited = new boolean[graph.adjList.size()];
		visited[v] = true;
		while(!q.isEmpty()) {
			int temp = q.remove();
			System.out.print(temp +  " ");
			for(int vertex : graph.adjList.get(temp)) {
				if(visited[vertex] == false) {
					q.add(vertex);
					visited[vertex] = true;
				}
			}
		}
	}
	
	public void reachAllVertexFromSrc(Graph2 graph, int src, boolean[] visited) {
		if(visited[src] == false) {
			visited[src] = true;
			for(int vertex : graph.adjList.get(src)) {
				reachAllVertexFromSrc(graph, vertex, visited);
			}
			
		}
	}
	
	public void bfs_matrix(int[][]mat, int src) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		boolean[] visited = new boolean[mat.length];
		visited[src] = true;
		while(!q.isEmpty()) {
			for(int i = 0; i < mat.length; i++) {
				if(mat[src][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public void dfs_matrix(int[][] mat, int src) {
		Stack<Integer> s = new Stack<>();
		s.add(src);
		boolean[] visited = new boolean[mat.length];
		visited[src] = true;
		while(!s.empty()) {
			for(int i = 0; i < mat.length; i ++) {
				if(mat[src][i] == 1 && visited[i] == false) {
					s.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public void floodFill(int[][] mat, Cell src, int[][] visited) {
		int[] row = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] col = {0, 1, 1, 1, 0, -1, -1, -1};
		Queue<Cell> q = new LinkedList<>();
		q.add(src);
		visited[src.x][src.y] = 1;
		while(!q.isEmpty()) {
			Cell temp = q.remove();
			mat[temp.x][temp.y] = 9;
			for(int i = 0; i < 8; i ++) {
				int xRow = temp.x + row[i];
				int yCol = temp.y + col[i];
				if(isValidCell(mat, xRow, yCol, visited)){
					q.add(new Cell(xRow, yCol));
					visited[xRow][yCol] = 1;
				}
			}
		}
		
		for(int i = 0; i < mat.length; i ++) {
			for(int j = 0; j < mat[0].length; j ++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	private boolean isValidCell(int[][]mat, int x, int y, int[][] visited) {
		if(x < 0 || y < 0 || x >= visited.length || y >= visited.length || visited[x][y] == 1 || mat[x][y] != 2 ) {
			return false;
		}
		return true;
	}
	
	
	public void findIsland(int[][] mat, Cell src, int[][] visited) {
		int[] row = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] col = {0, 1, 1, 1, 0, -1, -1, -1};
		Queue<Cell> q = new LinkedList<>();
		q.add(src);
		visited[src.x][src.y] = 1;
		while(!q.isEmpty()) {
			Cell temp = q.remove();
			for(int i = 0; i < 8; i ++) {
				int xRow = temp.x + row[i];
				int yCol = temp.y + col[i];
				if(isValidCell_forIsland(mat, xRow, yCol, visited)){
					q.add(new Cell(xRow, yCol));
					visited[xRow][yCol] = 1;
				}
			}
		}
		
	}
	private boolean isValidCell_forIsland(int[][]mat, int x, int y, int[][] visited) {
		if(x < 0 || y < 0 || x >= visited.length || y >= visited.length || visited[x][y] == 1 || mat[x][y] == 0 ) {
			return false;
		}
		return true;
	}
	
	public void detectCycleInUndirectedGraph(Graph2 graph, int src) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		int[] parent = new int[graph.adjList.size()];
		Arrays.fill(parent, -1);
		boolean[] visited = new boolean[graph.adjList.size()];
		visited[src] = true;
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			for(int vertex : graph.adjList.get(temp)) {
				if(visited[vertex] == false) {
					q.add(vertex);
					visited[vertex] = true;
					parent[vertex] = temp;
				}else {
					if(parent[temp] != vertex) {
						System.out.println("Cycle found");
						return;
					}
				}
			}
		}
		System.out.println("No cycle detected");
	}
	
	public boolean detectCycleInDirectedGraph(Graph2 graph, int src) {
		 Stack<Integer> s = new Stack<>();
		 s.add(src);
		 int[] visited = new int[graph.adjList.size()];
		 Arrays.fill(visited, -1);
		 visited[src] = 0;
		 
		 while(!s.empty()) {
			 int temp = s.peek();
			 for(int vertex: graph.adjList.get(temp)) {
				 if(visited[vertex] == -1) {
					 s.add(vertex);
					 visited[vertex] = 0;
				 }else if(visited[vertex] == 0) {
					 return true;
				 }
			 }
			 if(temp == s.peek()) {
				 s.pop();
				 visited[temp] = 1;
			 }
		 }
		 return false;
	} 
	
	public void binaryMaze_shortestDis(int[][] mat, Cell src, Cell destn) {
		int[] row = {-1, -1, -1, 1, 1, 1, 0, 0};
		int[] col = {0, -1, 1, 0, -1, 1, -1, 1};
		int[][] cost = new int[mat.length][mat[0].length];
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		Queue<Cell> q = new LinkedList<>();
		q.add(src);
		visited[src.x][src.y] = true;
		cost[src.x][src.y] = 1;
		while(!q.isEmpty()) {
			Cell temp = q.remove();
			if(temp.x == destn.x && temp.y == destn.y) {
				System.out.println("Found the destn with cost " + cost[temp.x][temp.y]);
				return;
			}
			for(int i = 0; i < 8; i ++) {
				int nextX = temp.x + row[i];
				int nextY = temp.y + col[i];
				if(isValidCell_MazeProblem(mat, nextX, nextY, visited)) {
					q.add(new Cell(nextX, nextY));
					visited[nextX][nextY] = true;
					cost[nextX][nextY] = cost[temp.x][temp.y] + 1;
				}
			}
		}
		System.out.println("Destn not found");
	}
	private boolean isValidCell_MazeProblem(int[][]mat, int x, int y, boolean[][] visited) {
		if(x < 0 || y < 0 || x >= visited.length || y >= visited.length || visited[x][y] == true || mat[x][y] == 0) {
			return false;
		}
		return true;
	}
	
	
	public void findShortestPathInDirectedGraph(int[][] mat, int src) { //using dijkstra algo
		boolean[] visited = new boolean[mat.length];
		int[] distance = new int[mat.length];
		Arrays.fill(distance, 999);
		distance[src] = 0;
		int[] predecessor = new int[mat.length];
		predecessor[src] = -1;
		
		for(int i = 0; i < mat.length - 1; i++) {
			int u = findMinDis(mat, distance, visited);
			visited[u] = true;
			for(int j = 0; j < mat.length; j++) {
				if(mat[u][j] != 0 && distance[u] + mat[u][j] < distance[j]) {
					distance[j] = distance[u] + mat[u][j];
					predecessor[j] = u;
				}
			}
		}
		for(int i = 0; i < distance.length; i++) {
			System.out.println(i + " " + distance[i] + " ");
		}
		int destn = 5;
		while(destn != -1) {
			System.out.println(destn + " -> ");
			destn = predecessor[destn];
		}
	}
	private int findMinDis(int[][] mat, int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int minVertex = -1;
		for(int i = 0; i < mat.length; i ++) {
			for(int j = 0; j < mat[0].length; j ++) {
				if(mat[i][j] != 0 && visited[i] == false && distance[i] + mat[i][j] < min) {
					min = distance[i] + mat[i][j];
					minVertex = i;
				}
			}
		}
		return minVertex;
	}
	
	public void findShortestPathInDirectedGraph2(int[][] mat, int src) { //bellmon ford algo
		int[] distance = new int[mat.length];
		Arrays.fill(distance, 9998932);
		distance[src] = 0;
		for (int k = 0; k < mat.length; k++) { //llop for |V| -1 because we will want to relax shortest |V|-1 edge
			for (int i = 0; i < mat.length - 1; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					if (mat[i][j] != 0 && distance[i] + mat[i][j] < distance[j]) {
						distance[j] = distance[i] + mat[i][j];
					}
				}
			}
		}
		for(int i = 0; i < distance.length; i++) {
			System.out.println(i + " " + distance[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		Graph2 graph = new Graph2(Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(1, 4), new Edge(2, 3),
				new Edge(4, 5), new Edge(6, 2)), 7);
//		graph.dfs(graph, 0);
//		System.out.println();
//		graph.dfs_recursive(graph, 0, new boolean[graph.adjList.size()]);
//		System.out.println();
//		graph.bfs(graph, 0);
//		
//		System.out.println();
//		boolean[] visited = new boolean[graph.adjList.size()];
//		for(int i = 0; i < graph.adjList.size() - 1; i ++) {
//			graph.reachAllVertexFromSrc(graph, i, visited);
//			
//		}
//		for(int i = 0; i  < graph.adjList.size(); i ++) {
//			System.out.println(i +": "+ visited[i]);
//		}
		
//		int[][] colorPixel= {{0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 1, 2, 2, 2, 0},
//							 {0, 0, 0, 0, 1, 2, 2, 0},
//							 {0, 0, 0, 0, 1, 2, 2, 2},
//							 {0, 0, 0, 0, 0, 1, 2, 2},
//							 {0, 0, 0, 0, 0, 0, 1, 2},
//							 {0, 0, 0, 0, 0, 0, 0, 1},
//							 {0, 0, 2, 0, 0, 0, 0, 0}};
//		
//		int[][] visitedPixel={{0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0},
//							 {0, 0, 0, 0, 0, 0, 0, 0}};
//		graph.floodFill(colorPixel, new Cell(3, 7), visitedPixel);
		
//		int[][] island= {{0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 1, 1, 1, 1, 0},
//				 {0, 0, 0, 0, 1, 1, 1, 0},
//				 {0, 1, 0, 0, 1, 1, 1, 1},
//				 {0, 0, 0, 0, 0, 1, 1, 1},
//				 {1, 0, 1, 0, 0, 0, 1, 1},
//				 {0, 1, 0, 0, 0, 0, 0, 1},
//				 {0, 0, 0, 0, 0, 0, 0, 0}};
//		
//		int[][] visitedIsland={{0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0},
//				 {0, 0, 0, 0, 0, 0, 0, 0}};
//		int connectedIslandCount = 0;
//		for(int i = 0; i < island.length; i ++) {
//			for(int j = 0; j < island[0].length; j ++) {
//				if(island[i][j] != 0 && visitedIsland[i][j] != 1) {
//					connectedIslandCount ++;
//					graph.findIsland(island, new Cell(i, j), visitedIsland);
//				}
//			}
//		}
//		System.out.println("Connected Island " + connectedIslandCount);
		
//		Graph2 unDirGraph = new Graph2(Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), 
//				 new Edge(2, 0)), 4);
//		System.out.println(unDirGraph.detectCycleInDirectedGraph(unDirGraph, 0));
		
//		Graph2 dirGraph = new Graph2(Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(0, 2)), 3);
//		System.out.println(dirGraph.detectCycleInDirectedGraph(dirGraph, 0));
		
//		int[][] maze= 	{{1, 0, 0, 0, 0, 0, 0, 0},
//						 {0, 1, 1, 1, 1, 0, 0, 0},
//						 {0, 1, 0, 0, 1, 0, 0, 0},
//						 {0, 0, 1, 0, 1, 0, 0, 0},
//						 {0, 0, 1, 0, 1, 0, 0, 0},
//						 {0, 0, 0, 1, 1, 0, 0, 0},
//						 {0, 0, 0, 0, 0, 0, 0, 0},
//						 {0, 0, 0, 0, 0, 0, 0, 0}};
//		
//		Graph2 mazeP = new Graph2();
//		mazeP.binaryMaze_shortestDis(maze, new Cell(0, 0), new Cell(5, 3));
		
		int mat[][] = new int[][]	{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
						            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
						            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
						            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
						            {0, 0, 0, 9, 0, 10, 0, 0, 0},  
						            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
						            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
						            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
						            {0, 0, 2, 0, 0, 0, 6, 7, 0}}; 
						           
           
           Graph2 singleSrcShortPath = new Graph2();
           singleSrcShortPath.findShortestPathInDirectedGraph(mat, 0);
           singleSrcShortPath.findShortestPathInDirectedGraph2(mat, 0);
		
	}
}
