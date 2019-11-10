package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		
		for(int i = 0; i < adjList.size(); i++) {
			for(int j = 0; j < adjList.get(i).size(); j++) {
				Vertex v = adjList.get(i).get(j);
				v.color = Color.WHITE;
				v.pred = null;
				v.distance = 0;
			}
		}
	}
	
	public void bfs(Vertex s) {
		Queue<Vertex> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()) {
			Vertex temp = q.remove();
			System.out.print(temp.vertex + " ");
			for(int i = 0; i < adjList.get(temp.vertex).size(); i++) {
				Vertex nebr = adjList.get(temp.vertex).get(i);
				if(nebr.color.equals(Color.WHITE)) {					
					q.add(nebr);
					nebr.color = Color.GREY;
					nebr.pred = temp;
					nebr.distance = temp.distance + 1;
				}
			}
			//we have visited all neighbour of temp so we mark it as black
			temp.color = Color.BLACK;
		}
	}
	

}
