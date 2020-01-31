public class UGraph
{
	private int vertexCount;
	private int edgeCount;
	private LinkList[] vertexSet;

	public UGraph(){
		vertexSet = new LinkList[0];
	}

	public int getVertexCount(){
		return vertexCount;
	}

	public int getEdgeCount(){
		return edgeCount;
	}

	public void insertVertex(String vertex){
		LinkList[] temp = new LinkList[vertexSet.length+1];

		for(int i = 0; i < vertexSet.length; i++){
			temp[i] = vertexSet[i];
		}

		LinkList newVertex = new LinkList(vertex);

		temp[vertexSet.length] = newVertex;
		vertexSet = temp;

		vertexCount++;
		
	}

	public void removeVertex(String vertex){
		LinkList[] temp = new LinkList[vertexSet.length-1];
		int j = 0;

		if(temp.length > 0){
			for(int i = 0; i < vertexSet.length; i++){
				if(vertexSet[i].getName().equals(vertex)){
					String[] list = vertexSet[i].getList();
					edgeCount = edgeCount - list.length;
					continue;
				}
				vertexSet[i].removeLink(vertex);
				temp[j++] = vertexSet[i];
			}
		}

		vertexSet = temp;

		vertexCount--;
	}

	public void insertEdge(String a, String b){
		for(int i = 0; i < vertexSet.length; i++){
			if(vertexSet[i].getName().equals(a)){
				vertexSet[i].addLink(b);
			}
			if(vertexSet[i].getName().equals(b)){
				vertexSet[i].addLink(a);
			}
		}
		edgeCount++;
	}

	public void removeEdge(String a, String b){
		for(int i = 0; i < vertexSet.length; i++){
			if(vertexSet[i].getName().equals(a)){
				vertexSet[i].removeLink(b);
			}
			if(vertexSet[i].getName().equals(b)){
				vertexSet[i].removeLink(a);
			}
		}
		edgeCount--;
	}

	public String[] getAdjacents(String vertex){
		for(int i = 0; i < vertexSet.length; i++){
			if(vertexSet[i].getName().equals(vertex)){
				return vertexSet[i].getList();
			}
		}
		return null;
	}

	public boolean isAdjacent(String a, String b){
		for(int i = 0; i < vertexSet.length; i++){
			if(vertexSet[i].getName().equals(a)){
				return vertexSet[i].findValue(b);
			}
		}
		return false;
	}

	public boolean isConnected(LinkList removed, String a, String b){
		for(int i = 0; i < vertexSet.length; i++){
			if(vertexSet[i].getName().equals(a)){
				if(vertexSet[i].findValue(b)){
					return true;
				}
				else{
					String[] adjacents = vertexSet[i].getList();
					removed.addLink(vertexSet[i].getName());

					for(int j = 0; j < adjacents.length; j++){
						if(!removed.findValue(adjacents[j]) && isConnected(removed, adjacents[j], b)){
							return true;
						}
					}
					return false;
				}
			}
		}
		return false;
	}

	private boolean contains(String[] array, String a){
		for(String k : array){
			if(k.equals(a)){
				return true;
			}
		}
		return false;
	}

	public String[] depthFirst(String first){
		String[] visited = new String[vertexCount];
		visited[0] = first;
		Stack stack = new Stack();

		String current = first;

		do{
			stack.push(first);
			String[] adjacents = getAdjacents(current);
			for(String a : adjacents){
				 if(!contains(visited, a)){
				 	stack.push();
				 }
			}
		}while(!stack.isEmpty());
	}
}