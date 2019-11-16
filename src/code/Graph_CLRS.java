package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph_CLRS {
	List<List<Vertex>> adjList = new ArrayList<>();
	enum Color {BLACK, GREY, WHITE};
	static class Vertex{
		int vertex;
		Vertex pred;
		Color color;
		int distance;
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
	public void graph(List<Edge> edges) {
		for(int i = 0; i < edges.size(); i++) {
			adjList.add(i, new ArrayList<Vertex>());
		}
		
		for(Edge e: edges) {
			adjList.get(e.src.vertex).add(e.destn);
		}
	}
	
	public void reset() {
		for(int i = 0; i < adjList.size(); i++) {
			for(Vertex v : adjList.get(i)) {
				v.color = Color.WHITE;
				v.pred = null;
				v.distance = -1;
			}
		}
	}
	
	//time- O(V+E) space- O(V)
	public void bfs(Vertex s) {
		reset(); //this is to ensure we are not re-using vertex which has been used.eg if you run bfs and dfs one after another it will give output correct
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
		reset();
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

}
