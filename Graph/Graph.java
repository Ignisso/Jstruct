interface Graph<E> {
	public void addVertex(E value);
	public void addVertex(E value, Integer index);
	public void addNeighborToVertex(Integer vertex, Integer neighbor);
	public void addNeighborToVertex(Integer vertex, Integer[] neighbors);
}