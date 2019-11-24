package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	List<List<Integer>> adjList = new ArrayList<>();
	static class Edge{
		int src, destn;
		Edge(int s, int d){
			this.src = s;
			this.destn = d;
		}			
	}
	
	static class Cell{
		int x, y, cost;
		Cell(int x1, int y1, int c){
			this.x = x1;
			this.y = y1;
			this.cost = c;
		}
		public void add(int k, int l) {
			this.x = this.x + k;
			this.y = this.y + l;
		}
	}
	
	Graph(List<Edge> edges, int V){
		for(int i = 0; i < V; i++ ) {
			adjList.add(i, new ArrayList<Integer>());
		}
		
		for(Edge e : edges) {
			adjList.get(e.src).add(e.destn);
		}
	}
	//time- O(n) space- O(n) in space two case ie.for skewed (1)and for worst (n) when one root has all other node as child
	public void bfsAdjList(int src) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		boolean[] visited = new boolean[20];
		visited[src] = true;
		
		while(!q.isEmpty()) {
			int temp = q.remove();
			System.out.print(temp + " ");
			for(int nebr: adjList.get(temp)) {
				if(visited[nebr] == false) {
					q.add(nebr);
					visited[nebr] = true;
				}
			}
		}
	}
	
	//time- O(n) space- O(n)
	public void dfsAdjList(int src, int V) {
		Stack<Integer> s = new Stack<>();
		s.push(src);
		boolean[] visited = new boolean[V];
		visited[src] = true;
		
		while(!s.empty()) {
			int temp = s.pop();
			System.out.print(temp + " ");
			for(int i = 0; i < adjList.get(temp).size(); i++) {
				if(visited[adjList.get(temp).get(i)] == false) {
					s.push(adjList.get(temp).get(i));
					visited[adjList.get(temp).get(i)] = true;
				}
			}
		}
		
	}
	
	public void dfsMatrix(int[][] mat, int u) {
		Stack<Integer> stack = new Stack<>();
		stack.push(u);
		boolean[] visited = new boolean[mat.length];
		visited[u] = true;
		
		while(!stack.empty()) {
			int temp = stack.pop();
			System.out.print(temp + " ");
			for(int i = 0; i < mat[temp].length; i++) {
				if(mat[temp][i] == 1) {
					if(visited[i] == false) {
						stack.push(i);
						visited[i] = true;		
					}
				}
			}
		}
	}
	
	private boolean isValid(int[][] mat, int x, int y, boolean[][] visited) {
		if (x >= 0 && x < mat.length && y >= 0 && y < mat.length && mat[x][y] != 1 && visited[x][y] == false) {
			return true;
		}
		return false;
	}
	
	public void isPathAvailable(int[][] mat, Cell src, Cell destn) {
		Queue<Cell> q = new LinkedList<>();
		boolean[][] visited = new boolean[mat.length][mat.length];
		int[] row = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] col = {-1, -1, 1, 1, 1, 0, -1, -1};
		boolean foundDestn = false;
		
		q.add(src);
		visited[src.x][src.y] = true;
		while(!q.isEmpty()) {
			Cell temp = q.remove();
			System.out.println("( " + temp.x + "," + temp.y + " )");
			if(temp.x == destn.x && temp.y == destn.y) {
				foundDestn = true;
				System.out.println("Path "+ foundDestn + " with cost " + temp.cost);
				return;
			}
			for(int i = 0; i < 8; i ++) {
				if (isValid(mat, temp.x + row[i], temp.y + col[i], visited)) {
					q.add(new Cell(temp.x + row[i], temp.y + col[i], temp.cost+1));
					visited[temp.x + row[i]][temp.y + col[i]] = true;
				}
			}
			
		}
		System.out.println("Path "+ foundDestn);
		
	}
}
