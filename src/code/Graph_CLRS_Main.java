package code;

import java.util.Arrays;
import java.util.List;

public class Graph_CLRS_Main {
	public static void main(String[] args) {
		Graph_CLRS g = new Graph_CLRS();
		List<Graph_CLRS.Edge> edges = Arrays.asList(new Graph_CLRS.Edge(new Graph_CLRS.Vertex(0), new Graph_CLRS.Vertex(1)),
				new Graph_CLRS.Edge(new Graph_CLRS.Vertex(1), new Graph_CLRS.Vertex(3)),
				new Graph_CLRS.Edge(new Graph_CLRS.Vertex(1), new Graph_CLRS.Vertex(2)),
				new Graph_CLRS.Edge(new Graph_CLRS.Vertex(4), new Graph_CLRS.Vertex(3)),
				new Graph_CLRS.Edge(new Graph_CLRS.Vertex(1), new Graph_CLRS.Vertex(5)),
				new Graph_CLRS.Edge(new Graph_CLRS.Vertex(2), new Graph_CLRS.Vertex(4)));
		g.graph(edges);
		g.bfs(new Graph_CLRS.Vertex(0));
	}

}
