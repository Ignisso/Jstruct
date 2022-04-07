import java.util.Map;
import java.util.HashMap;
import java.lang.NullPointerException;
import java.lang.StringBuilder;

public class BidirectionalGraph<E> implements Graph<E> {
	
	private class Vertex<E> {
		private DynamicArray<Vertex<E>> neighbors;
		private E                       value;
		private boolean                 visited;
		
		public Vertex(E value) {
			this.neighbors = new DynamicArray<Vertex<E>>();
			this.value     = value;
			this.visited   = false;
		}
		
		public void makeEdge(Vertex<E> vertex) {
			if (vertex == null)
				throw new NullPointerException("Tried to add null vertex");
			this.neighbors.add(vertex);
			vertex.neighbors.add(this);
		}
		
		public void makeEdge(Vertex<E>[] vertices) {
			for (Vertex<E> v : vertices) {
				if (v == null)
					throw new NullPointerException("Tried to add null vertex");
				this.neighbors.add(v);
				v.neighbors.add(this);
			}
		}
		
		public void makeEdge(DynamicArray<Vertex<E>> vertices) {
			for (Vertex<E> v : vertices) {
				if (v == null)
					throw new NullPointerException("Tried to add null vertex");
				this.neighbors.add(v);
				v.neighbors.add(this);
			}
		}
		
		public E getValue() {
			return this.value;
		}
		
		public DynamicArray<Vertex<E>> getNeighbors() {
			return this.neighbors;
		}
	}
	
	
	
	private HashMap<Integer, Vertex<E>> vertices;
	private Integer                     index;
	
	public BidirectionalGraph() {
		this.vertices = new HashMap<Integer, Vertex<E>>();
		this.index    = 0;
	}
	
	public void addVertex(E value) {
		while (this.vertices.get(this.index) != null)
			this.index++;
		this.vertices.put(this.index, new Vertex<E>(value));
	}
	
	public void addVertex(E value, Integer index) {
		if (this.vertices.get(this.index) == null)
			throw new RuntimeException("Vertex at " + index + " already exists");
		this.vertices.put(index, new Vertex<E>(value));
	}
	
	public void addNeighborToVertex(Integer vertex, Integer neighbor) {
		if (this.vertices.get(vertex) == null)
			throw new NullPointerException("Vertex at " + vertex + "does not exist");
		if (this.vertices.get(neighbor) == null)
			throw new NullPointerException("Vertex at " + neighbor + "does not exist");
		this.vertices.get(vertex).makeEdge(this.vertices.get(neighbor));
	}
	
	public void addNeighborToVertex(Integer vertex, Integer[] neighbors) {
		if (this.vertices.get(vertex) == null)
			throw new NullPointerException("Vertex at " + vertex + "does not exist");
		for (Integer i : neighbors) {
			if (this.vertices.get(i) == null)
				throw new NullPointerException("Vertex at " + i + "does not exist");
			this.vertices.get(vertex).makeEdge(this.vertices.get(i));
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Vertex<E>> set : this.vertices.entrySet())
			sb.append(set.getKey() + ":" + set.getValue().getValue() + " ");
		return sb.toString();
	}
}