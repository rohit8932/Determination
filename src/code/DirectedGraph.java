package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraph {
	static class wEdge{
		int src, destn, cost;
		wEdge(int s, int d, int c){
			this.src = s;
			this.destn = d;
			this.cost = c;
		}
	}
	List<List<wEdge>> adjList = new ArrayList<>();
	
	public DirectedGraph(List<wEdge> edges, int V) {
		for(int i = 0; i < V; i ++) {
			adjList.add(i, new ArrayList<>());
		}
		for(wEdge edge : edges) {
			adjList.get(edge.src).add(edge);
		}
		
	}
	
	//time- O(V * E) space-O(N)
	public void getMinCostToReachDestn(DirectedGraph dg, int src, int destn) {
		int[] distance = new int[dg.adjList.size()];
		boolean[] visited = new boolean[dg.adjList.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		distance[src] = 0;
		for(int i = 0; i < dg.adjList.size()-1; i++) {
			int u = getMinCostVertex(dg, distance, visited);
			visited[u] = true;
			for(wEdge edge : dg.adjList.get(u)) {
				if(visited[edge.destn] == false && distance[u] + edge.cost < distance[edge.destn]) {
					distance[edge.destn] = distance[u] + edge.cost;
				}
			}
		}
		
		System.out.println("min Distance to reach from " + src + " to " + destn + " is " + distance[destn]);
	}
	private int getMinCostVertex(DirectedGraph dg, int[] distance, boolean[] visited) {
		int minVertex = -1, minCost = Integer.MAX_VALUE;
		for(int i = 0; i < distance.length; i++) {
			if(distance[i] < minCost && visited[i] == false) {
				minCost = distance[i];
				minVertex = i;
			}
		}
		return minVertex;
	}
	
	
	public void getMaxCostToReachDestn(DirectedGraph dg, int src, int destn) {
		int[] distance = new int[dg.adjList.size()];
		boolean[] visited = new boolean[dg.adjList.size()];
		Arrays.fill(distance, Integer.MIN_VALUE);
		Arrays.fill(visited, false);
		distance[src] = 0;
		for(int i = 0; i < dg.adjList.size()-1; i++) {
			int u = getMaxCostVertex(dg, distance, visited);
			visited[u] = true;
			for(wEdge edge : dg.adjList.get(u)) {
				if(visited[edge.destn] == false && distance[u] + edge.cost > distance[edge.destn]) {
					distance[edge.destn] = distance[u] + edge.cost;
				}
			}
		}
		
		for(int i : distance)
			System.out.print(i + " ");
		
		//System.out.println("max Distance to reach from " + src + " to " + destn + " is " + distance[destn]);
	}
	
	private int getMaxCostVertex(DirectedGraph dg, int[] distance, boolean[] visited) {
		int minVertex = -1, minCost = Integer.MIN_VALUE;
		for(int i = 0; i < distance.length; i++) {
			if(distance[i] > minCost && visited[i] == false) {
				minCost = distance[i];
				minVertex = i;
			}
		}
		return minVertex;
	}

}
