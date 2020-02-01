package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import code.DirectedGraph.wEdge;

public class DirectedGraphMain {
	public static void main(String[] args) {
		List<wEdge> edges = new ArrayList<>(Arrays.asList(new wEdge(0, 6, 11),new wEdge(0, 1, 5),new wEdge(1, 6, 3),
				new wEdge(1, 5, 5),new wEdge(1, 2, 7),new wEdge(2, 3, -8),new wEdge(3, 4, 10),new wEdge(5, 2, -1),
				new wEdge(5, 3, 9),new wEdge(5, 4, 1),new wEdge(6, 5, 2),new wEdge(7, 6, 9),new wEdge(7, 1, 6)));
		
		DirectedGraph dg = new DirectedGraph(edges, 8);
		dg.getMinCostToReachDestn(dg, 0, 7);
		dg.getMaxCostToReachDestn(dg, 0, 4);
	}

}
