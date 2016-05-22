
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.addVertex("Warszawa");
		g.addVertex("Poznañ");
		g.addVertex("Wroc³aw");
		g.addVertex("Konin");
		g.addVertex("Gdañsk");
		g.addVertex("Szczecin");
		g.addVertex("Zakopane");
		g.addEdge("Warszawa", "Poznañ", 200);
		g.addEdge("Konin", "Poznañ", 80);
		g.addEdge("Poznañ", "Wroc³aw", 250);
		g.addEdge("Konin", "Warszawa", 300);
		g.addEdge("Wroc³aw", "Konin", 190);
		g.addEdge("Warszawa", "Konin", 180);
		g.addEdge("Warszawa", "Gdañsk", 300);
		g.addEdge("Gdañsk", "Szczecin", 250);
		g.addEdge("Konin", "Zakopane", 400);
		g.addEdge("Poznañ", "Szczecin", 300);
		
		g.dijkstra("Konin");
		System.out.println("");
		g.BFS("Warszawa");
		System.out.println("");
		g.DFS("Warszawa");
		
		Graph g1 = new Graph();
		g1.addVertex("0");
		g1.addVertex("1");
		g1.addVertex("2");
		g1.addVertex("3");
		g1.addVertex("4");
		g1.addVertex("5");
		g1.addEdge("0", "1", 3);
		g1.addEdge("0", "4", 3);
		g1.addEdge("1", "2", 1);
		g1.addEdge("2", "3", 3);
		g1.addEdge("2", "5", 1);
		g1.addEdge("3", "1", 3);
		g1.addEdge("4", "5", 2);
		g1.addEdge("5", "0", 6);
		g1.addEdge("5", "3", 1);
		
	
//		g1.displayNeighbors("Warszawa");
//		System.out.println(g.distance("Warszawa", "Konin"));
//		System.out.println(g.adjacencyList);
//		g1.dijkstra("0", "5");
//		g1.BFS("0");
//		g1.DFS("0");
	}

}
