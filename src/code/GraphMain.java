package code;

import java.util.Arrays;
import java.util.List;

public class GraphMain {
	public static void main(String[] args) {
		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(0, 3), new Graph.Edge(0, 1), new Graph.Edge(1, 2),
				new Graph.Edge(2, 0), new Graph.Edge(2, 3));
		int[][] mat = new int[4][4];
		mat[0][1] = 1;
		mat[0][3] = 1;
		mat[1][2] = 1;
		mat[2][3] = 1;
		mat[2][0] = 1;
		Graph graph = new Graph(edges, 4);
		
//		graph.bfsAdjList(0);
//		System.out.println();
//		graph.dfsAdjList(0, 4);
//		System.out.println();
//		graph.dfsMatrix(mat, 0);
		
		int[][] shortestPathMatrix= {{0, 1, 0, 0, 0, 0, 0, 0},
									 {1, 0, 0, 1, 0, 0, 0, 0},
									 {0, 1, 0, 1, 0, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0, 0},
									 {0, 0, 1, 0, 1, 0, 0, 0},
									 {0, 0, 0, 1, 0, 1, 0, 0},
									 {0, 0, 0, 1, 0, 1, 0, 0},
									 {0, 0, 0, 0, 0, 0, 0, 0}};		
		graph.shortestPath(shortestPathMatrix, new Graph.Cell(0, 0), new Graph.Cell(7, 7));
		}
	}


