package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphMain {
	public static void main(String[] args) {
//		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(0, 3), new Graph.Edge(0, 1), new Graph.Edge(1, 2),
//				new Graph.Edge(2, 0), new Graph.Edge(2, 3));
//		int[][] mat = new int[4][4];
//		mat[0][1] = 1;
//		mat[0][3] = 1;
//		mat[1][2] = 1;
//		mat[2][3] = 1;
//		mat[2][0] = 1;
//		Graph graph = new Graph(edges, 4);
		
//		graph.bfsAdjList(0);
//		System.out.println();
//		graph.dfsAdjList(0, 4);
//		System.out.println();
//		graph.dfsMatrix(mat, 0);
		
//		int[][] shortestPathMatrix= {{0, 1, 0, 0, 0, 0, 0, 0},
//									 {1, 0, 0, 1, 0, 0, 0, 0},
//									 {0, 1, 0, 1, 0, 0, 0, 0},
//									 {0, 0, 1, 0, 1, 0, 0, 0},
//									 {0, 0, 1, 0, 1, 0, 0, 0},
//									 {0, 0, 0, 1, 0, 1, 0, 0},
//									 {0, 0, 0, 1, 0, 1, 1, 1},
//									 {0, 0, 0, 0, 0, 0, 0, 0}};		
//		graph.isPathAvailable(shortestPathMatrix, new Graph.Cell(0, 0, 0), new Graph.Cell(7, 7, 0));
		
		//Snake Ladder problem
//		Map<Integer, Integer> ladder = new HashMap<Integer, Integer>(); 
//		Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
//		ladder.put(1, 38);
//		ladder.put(4, 14);
//		ladder.put(9, 31);
//		ladder.put(21, 42);
//		ladder.put(28, 84);
//		ladder.put(51, 67);
//		ladder.put(72, 91);
//		ladder.put(80, 99);
//		
//		snake.put(17, 7);
//		snake.put(54, 34);
//		snake.put(62, 19);
//		snake.put(64, 60);
//		snake.put(87, 36);
//		snake.put(93, 73);
//		snake.put(95, 75);
//		snake.put(98, 79);
//		graph.minNumThrowReqToWinSnakeLadder(ladder, snake);
		
//		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(0, 1), new Graph.Edge(1, 2), new Graph.Edge(2, 3),
//				new Graph.Edge(4, 5));
//		Graph g = new Graph(edges,6);
//		g.routeBtwNodes(g, 0, 5, new boolean[6]);
		
		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(5, 0), new Graph.Edge(4, 0), new Graph.Edge(5, 2),
				new Graph.Edge(4, 1),new Graph.Edge(2, 3), new Graph.Edge(3, 1));
//		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(0, 1), new Graph.Edge(1, 0));
		Graph graph = new Graph(edges, 6);
//		graph.getIndegreeOfNodes(graph);
		graph.resolveDependency(graph);
		
		
		}
	}


