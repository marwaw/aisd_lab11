
public class Edge {
//	Vertex a;
	Vertex b;
	int weight;
	
	public Edge(Vertex b, int w){
		this.b = b;
		weight = w;
	}
	
	public Vertex getNeighbor(){
		return b;
	}
	
	public String neighbor(){
		return b.toString();
	}
	
	public String toString(){
		return b.toString() + " waga: " + weight;
	}

}
