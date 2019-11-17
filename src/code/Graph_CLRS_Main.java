package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph_CLRS_Main {
	public static void main(String[] args) {
		/*
		 * 	0----->1     2
		 *  |     Y|    /|
		 *  |    / |   / |
		 *  |   /  |  /  |
		 *  |  /   | /   |
		 *	v /    VY    V
		 *  3<-----4     5
		 * 
		 */
		Graph_CLRS g = new Graph_CLRS();
		List<Graph_CLRS.Vertex> vertices = new ArrayList<>();
		vertices.add(new Graph_CLRS.Vertex(0));
		vertices.add(new Graph_CLRS.Vertex(1));
		vertices.add(new Graph_CLRS.Vertex(2));
		vertices.add(new Graph_CLRS.Vertex(3));
		vertices.add(new Graph_CLRS.Vertex(4));
		vertices.add(new Graph_CLRS.Vertex(5));
		
		List<Graph_CLRS.Edge> edges = Arrays.asList(new Graph_CLRS.Edge(vertices.get(0), vertices.get(1)),
				new Graph_CLRS.Edge(vertices.get(0), vertices.get(3)),
				new Graph_CLRS.Edge(vertices.get(1), vertices.get(4)),
				new Graph_CLRS.Edge(vertices.get(4), vertices.get(3)),
				new Graph_CLRS.Edge(vertices.get(3), vertices.get(1)),
				new Graph_CLRS.Edge(vertices.get(2), vertices.get(4)),
				new Graph_CLRS.Edge(vertices.get(2), vertices.get(5)));
		g.graph(edges);
		g.bfs(vertices.get(0));
		g.reset(vertices); //this is to ensure we are not re-using vertex which has been used and changed properties
								//eg if you run bfs and dfs one after another it will give output correct
		System.out.println();
		g.dfs(vertices.get(0));
		System.out.println();
		g.reset(vertices);
		for(Graph_CLRS.Vertex v : vertices) {
			if(v.color.equals(Graph_CLRS.Color.WHITE)) {
				g.dfs_withTimeStamp(v);
			}
		}
		
	}

}
