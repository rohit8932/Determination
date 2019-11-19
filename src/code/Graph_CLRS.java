package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph_CLRS {
	List<List<Vertex>> adjList = new ArrayList<>();
	int time = 0;
	enum Color {BLACK, GREY, WHITE};
	static class Vertex{
		int vertex;
		Vertex pred;
		Color color;
		int distance;
		int d_time; //d.time and f.time will be used for dfs 
		int f_time;
		Vertex(int v){
			this.vertex = v;
			this.pred = null;
			this.color = Color.WHITE;
			this.distance = 0;
		}
	}
	
	static class Edge{
		Vertex src, destn;
		Edge(Vertex s, Vertex d){
			this.src = s;
			this.destn = d;
		}
	}
	
	//time- O(E) space- O(E)
	public void graph(int V, List<Edge> edges) {
		for(int i = 0; i < V; i++) {
			adjList.add(i, new ArrayList<Vertex>());
		}
		
		for(Edge e: edges) {
			adjList.get(e.src.vertex).add(e.destn);
		}
	}
	
	public void reset(List<Vertex> vertices) {
		for (Vertex v : vertices) {
			v.color = Color.WHITE;
			v.pred = null;
			v.distance = -1;
			v.d_time = -1;
			v.f_time = -1;
		}

	}
	
	//time- O(V+E) space- O(V)
	public void bfs(Vertex s) {
		Queue<Vertex> q = new LinkedList<>();
		q.add(s);
		s.color = Color.WHITE;
		s.distance = -1;
		s.pred = null;
		while(!q.isEmpty()) {
			Vertex temp = q.remove();
			System.out.print(temp.vertex + " ");
			for(int i = 0; i < adjList.get(temp.vertex).size(); i++) {
				Vertex nebr = adjList.get(temp.vertex).get(i);
				if(nebr.color.equals(Color.WHITE)) {	
					nebr.color = Color.GREY;
					nebr.pred = temp;
					nebr.distance = temp.distance + 1;
					q.add(nebr);
				}
			}
			//we have visited all neighbours of temp so we mark it as black
			temp.color = Color.BLACK;
		}
	}
	
	//time- O(V+E) space- O(V)
	public void dfs(Vertex src) {
		Stack<Vertex> s = new Stack<>();
		s.push(src);
		src.color = Color.GREY;
		src.distance = 0;
		src.pred = null;
		while(!s.empty()) {
			Vertex temp = s.pop();
			System.out.print(temp.vertex + " ");
			for(int i = 0; i < adjList.get(temp.vertex).size(); i++) {
				Vertex v = adjList.get(temp.vertex).get(i);
				if(v.color.equals(Color.WHITE)) {
					v.color = Color.GREY;
					v.pred = temp;
					v.distance = temp.distance + 1;
					s.add(v);
				}
			}
			temp.color = Color.BLACK;
		}
	}
	
	//time- space-
	public void dfs_withTimeStamp(Vertex u) {
		System.out.print(u.vertex + " ");
		time = time + 1;
		u.d_time = time;
		u.color = Color.GREY;
		for(Vertex v : adjList.get(u.vertex)) {
			if(v.color.equals(Color.WHITE)) {
				//from visited vertex to unvisited vertex is tree edge (normal use case)
				System.out.println("Tree Edge "+ u.vertex + " -> " + v.vertex);
				v.pred=u;
				dfs_withTimeStamp(v);
			}
			else if(v.color.equals(Color.GREY)) {
				//from grey node to grey node, which means child pointing to ancestor 
				System.out.println("Back Edge "+ u.vertex + " -> " + v.vertex);
			}else if(v.color.equals(Color.BLACK)) {
				if(v.d_time < u.d_time) {
				//from grey node to black, if ancestor finish time found which means current node reachable from pointed node
					System.out.println("Cross Edge "+ u.vertex + " -> " + v.vertex);
					return;
				}
				//from grey node to black, if ancestor finish time still not found which means current node reachable from pointed node
				System.out.println("Forward Edge "+ u.vertex + " -> " + v.vertex);
			}
		}
		u.color=Color.BLACK;
		time = time + 1;
		u.f_time = time;
	}
	
	public void dfs_withTimeStamp_nonRecusive(Vertex u) {
		Stack<Vertex> s = new Stack<Graph_CLRS.Vertex>();
		time = 0;
		s.push(u);
		u.color = Color.GREY;
		u.pred = null;
		u.distance = 0;
		while(!s.empty()) {
			Vertex temp = s.peek();
			if(temp.color.equals(Color.GREY))
				temp.d_time = ++time;
			
			for(Vertex v : adjList.get(temp.vertex)) {
				if(v.color.equals(Color.WHITE)) {
					v.color = Color.GREY;
					v.pred = temp;
					s.push(v);
				}
			}
			temp.color = Color.BLACK;
			if(s.peek().color.equals(Color.BLACK)) {
				temp.f_time = ++time;
				s.pop();
			}
		}
	}
		

}
