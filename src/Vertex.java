
public class Vertex {
	private int index;
	private String value;
	boolean visited = false;
	
	public Vertex(String v, int i){
		value = v;
		index = i;
	}
	
	public String getValue(){
		return value;
	}

	public int getIndex(){
		return index;
	}
	
	public void visited(boolean vis){
		visited = vis;
	}
	
	public String toString(){
		return "Miasto: " + value;
	}

}
