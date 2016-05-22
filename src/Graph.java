import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int index;
	ArrayList<Vertex> vertices;
	ArrayList<ArrayList<Edge>> adjacencyList;
	
	public Graph(){
		index = 0;
		vertices = new ArrayList<>();
		adjacencyList = new ArrayList<>();
	}
	
	public Vertex search(String s, ArrayList<Vertex> ver){
		Iterator<Vertex> it = ver.iterator();
		while(it.hasNext()){
			Vertex temp = it.next();
			if (temp.getValue().compareTo(s) == 0) return temp;
		}
		return null;
	}
	
	public Edge searchEdge(String s, ArrayList<Edge> ver){
		Iterator<Edge> it = ver.iterator();
		while(it.hasNext()){
			Edge temp = it.next();
			if (temp.getNeighbor().getValue().compareTo(s) == 0) return temp;
		}
		return null;
	}
	
	public int distance(String a, String b){
		Vertex v1 = search(a, vertices);
		if (v1 == null || search(b, vertices) == null) throw new NullPointerException("Miasto nie istnieje!");
		int index = v1.getIndex();
		Edge e = searchEdge(b, adjacencyList.get(index));
		if (e == null) throw new NullPointerException("Nie ma takiej krawêdzi!");
		return e.weight;
	}
	
	public void addVertex(String s) throws Exception{
		if (search(s, vertices) != null) throw new Exception("Takie miasto ju¿ istnieje w grafie");
		Vertex v = new Vertex(s, index);
		adjacencyList.add(index, new ArrayList<>());
		index++;
		vertices.add(v);
	}
	
	public void addEdge(String a, String b, int weight){
		Vertex v1 = search(a, vertices);
		if (v1 != null){
			Vertex v2 = search(b, vertices);
			if (v2 == null){
//				v2 = new Vertex(b, index++);
				throw new NullPointerException("Takie miasto nie istnieje " + b);
			}
			Edge e = new Edge(v2, weight);
			int i = v1.getIndex();
			adjacencyList.get(i).add(e);
		}
	}
	
	public void dijkstra(String a){
		Vertex start = search(a, vertices);
		if (start != null){
			ArrayList<Vertex> notUsed = (ArrayList<Vertex>) vertices.clone();
			ArrayList<Vertex> used = new ArrayList<>();
			int[] distance = new int[notUsed.size()];
			int[] prev = new int[notUsed.size()];
			
			distance = wypelnijDistance(distance, start.getIndex());
			prev = wypelnijPrev(prev);
			
			while(!notUsed.isEmpty()){
				Vertex min = getMin(distance, notUsed);
				used.add(min);
				notUsed.remove(search(min.getValue(), notUsed));
//				System.out.println(notUsed.toString());
				Iterator<Edge> it = adjacencyList.get(min.getIndex()).iterator();
//				System.out.println("S¹siedzi " + min.toString());
//				System.out.println(adjacencyList.get(min.getIndex()));
				
				while(it.hasNext()){
					Edge temp = it.next();
					int neighIndex = temp.getNeighbor().getIndex();
					int weight = temp.weight;
					
					if (distance[neighIndex] > distance[min.getIndex()] + weight){
						distance[neighIndex] = distance[min.getIndex()] + weight;
						prev[neighIndex] = min.getIndex();
					}
				}
				
			}
			displayMinDis(distance, prev);
		}
	}
	
	public void BFS(String start){
		Queue<Vertex> kolejka = new LinkedList<>();
		Vertex ver = search(start, vertices);
		kolejka.add(ver);
		
		System.out.println("Przechodzenie wszerz: ");
		
		while(!kolejka.isEmpty()){
			Vertex odwiedzany = kolejka.peek();
			
			if (odwiedzany.visited == true) kolejka.poll();
			
			else{
				odwiedzany.visited(true);
				int ind = odwiedzany.getIndex();
				ArrayList<Edge> sasiedzi = adjacencyList.get(ind);
				
				for(int i = 0; i < sasiedzi.size(); i++){
					if (sasiedzi.get(i).getNeighbor().visited == false){
						kolejka.add(sasiedzi.get(i).getNeighbor());
					}
				}
				System.out.println("Odwiedzam: " + kolejka.poll().toString());
			}
		}
		setUnvisited();
	}
	
	public void DFS(String s){
//		setUnvisited();
		System.out.println("Przechodzenie wg³¹b: ");
		Vertex v = search(s, vertices);
		DFS(v);
	}
	
	private void DFS(Vertex v){
		System.out.println("Odwiedzam: " + v.toString());
		v.visited(true);
//		displayNeighbors(v.getValue());
		
		for (Edge e: adjacencyList.get(v.getIndex())){
			if (e.getNeighbor().visited == false) DFS(e.getNeighbor());
		}
	}
	
	private void setUnvisited(){
		Iterator<Vertex> it = vertices.iterator();
		while (it.hasNext()){
			it.next().visited(false);
		}
	}
	
	private int[] wypelnijDistance(int[] dis, int start){
		for(int i=0; i < dis.length; i++){
			if (i != start) dis[i] = (int) Integer.MAX_VALUE;
			else dis[i] = 0;
		}
		return dis;
	}
	
	private int[] wypelnijPrev(int[] prev){
		for (int i = 0; i < prev.length; i++){
			prev[i] = -1;
		}
		return prev;
	}
	
	private Vertex getMin(int[] arr, ArrayList<Vertex> ver){
		Vertex min = ver.get(0);
		Iterator<Vertex> it = ver.iterator();
		while(it.hasNext()){
			int i = it.next().getIndex();
			if (i < ver.size()){
				if(arr[i] < arr[min.getIndex()]) min = ver.get(i);
			}
		}
		return min;
	}
	
	private void displayMinDis(int[] tab, int[] prev){
		for (int i = 0; i < tab.length; i++){
			System.out.println("Dystans do " + vertices.get(i).getValue()+ " : " + tab[i]);
			System.out.printf("Œcie¿ka: ");
			System.out.printf(vertices.get(i).getValue() + " - ");
			int j = i;
//			if (prev[j] == -1) System.out.printf("pusta");
			while (prev[j] != -1){
				System.out.printf(vertices.get(prev[j]).getValue() + " - ");
				j = prev[j];
			}
			System.out.println("koniec ");
			System.out.println("------------------");
		}
	}
	
	public void displayNeighbors(String s){
		System.out.println("-------");
		System.out.println("S¹siedzi miasta: " + s);
		int i = search(s, vertices).getIndex();
		ArrayList<Edge> neighbors = adjacencyList.get(i);
		Iterator<Edge> it = neighbors.iterator();
		while(it.hasNext()){
			System.out.println(it.next().neighbor());
		}
		System.out.println("-------");
	}
	
	
	
}
