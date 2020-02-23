package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	//time- O(n) space- O(n)in space two case ie.for skewed (1)and for worst (n) when one root has all other node as child
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
	
	public void minNumThrowReqToWinSnakeLadder(Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {
		int N = 101;
		Graph g = new Graph(makeGraph(ladder, snake), N);
		
		//normal BFS
		boolean[] visited = new boolean[N + 1];
		int[] cost = new int[N + 1];
		Arrays.fill(cost,  -1);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		cost[1] = 0;
		while(!q.isEmpty()) {
			int temp = q.remove();
			for(int edge : g.adjList.get(temp)) {
				if(visited[edge] == false) {
					q.add(edge);
					visited[edge] = true;
					cost[edge] = cost[temp] + 1;
				}
			}
		}
		System.out.println("min cost to reach 100 is "+cost[100]);
	}
	private List<Edge> makeGraph(Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {
		int N = 100;
		int src, destn;
		List<Edge> edges = new ArrayList<Graph.Edge>();
		for(int i = 1; i <= N; i ++) {
			for(int j = 1; j < 6 && i + j <=100; j ++) {
				src = i;
				int _ladder = ladder.get(i+j) != null? ladder.get(i+j):0;
				int _snake = snake.get(i+j) != null? snake.get(i+j):0;
				
				if(_ladder != 0 || _snake != 0) { //both condition not possible
					destn = _ladder + _snake;
				}else {
					destn = i + j;
				}
				edges.add(new Edge(src, destn));
			}
		}
		return edges;
	}
	
	public void routeBtwNodes(Graph g, int src, int destn, boolean[] visited) {
		if(src == destn) {
			System.out.println(destn + " is reach able from source");
			return;
		}
		if(visited[src] == true) {
			return;
		}
		for(int i : g.adjList.get(src)) {
			if(visited[i] == false) {
				routeBtwNodes(g, i, destn, visited);
				visited[i] = true;
			}
		}
	}
	
	//time- O(V + E) space- O()
	public int[] getIndegreeOfNodes(Graph g) {
		int[] indegree = new int[g.adjList.size()];
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[g.adjList.size()];
		Arrays.fill(visited, false);
		for (int node = 0; node < g.adjList.size(); node++) {
			q.add(node);
			while (!q.isEmpty()) {
				int temp = q.remove();
				for (int e : g.adjList.get(temp)) {
						q.add(e);
						indegree[e]++;
						visited[e] = true;
				}
			}
		}
//		for(int i = 0; i < indegree.length; i++) 
//			System.out.println(i + " : " + indegree[i]);
		return indegree;
	}
	public void removeEdgeFromGraph(Graph g, int vertex, int[] indegree) {
		for(int e : g.adjList.get(vertex)){
			indegree[e]--;
		}
		g.adjList.get(vertex).clear();
	}
	
	//time- O(V+E) space- O()
	public void resolveDependency(Graph g) {
		int count=0;
		int[] indegree = new int[g.adjList.size()];
		Arrays.fill(indegree, 0);
		List<Integer> order = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int v = 0; v < adjList.size(); v ++) {
			for(int e = 0; e < adjList.get(v).size(); e ++) {
				indegree[adjList.get(v).get(e)]++;
			}
		}
		for(int i = 0; i < g.adjList.size(); i ++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int temp = q.remove();
			for(int v : adjList.get(temp)) {
				if(--indegree[v] == 0) {
					q.add(v);
				}
			}
			adjList.get(temp).clear();
			order.add(temp);
			count++;
		}
		if(count != adjList.size()) {
			System.out.println("Graph contains cycle");
		}
		for(int o : order)
			System.out.print(o + " ");
	}
	
	
}
