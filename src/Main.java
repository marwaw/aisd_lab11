
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Graph g = new Graph();
//		g.addVertex("Warszawa");
//		g.addVertex("Poznañ");
//		g.addVertex("Wroc³aw");
//		g.addVertex("Konin");
//		g.addEdge("Warszawa", "Poznañ", 200);
//		g.addEdge("Konin", "Poznañ", 80);
//		g.addEdge("Poznañ", "Wroc³aw", 250);
//		g.addEdge("Konin", "Warszawa", 300);
//		g.addEdge("Wroc³aw", "Konin", 190);
//		g.addEdge("Warszawa", "Konin", 180);
		
//		g.dijkstra("Warszawa", "Poznañ");
//		g.wszerz("Warszawa");
		
		g.addVertex("0");
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addEdge("0", "1", 3);
		g.addEdge("0", "4", 3);
		g.addEdge("1", "2", 1);
		g.addEdge("2", "3", 3);
		g.addEdge("2", "5", 1);
		g.addEdge("3", "1", 3);
		g.addEdge("4", "5", 2);
		g.addEdge("5", "0", 6);
		g.addEdge("5", "3", 1);
		
	
//		g.displayNeighbors("Warszawa");
//		System.out.println(g.distance("Warszawa", "Konin"));
//		System.out.println(g.adjacencyList);
//		g.dijkstra("0", "5");
		g.wszerz("0");
	}

}
