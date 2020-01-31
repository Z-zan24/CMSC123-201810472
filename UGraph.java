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

	public String[] depthFirst(){
		LinkList visited = new LinkList();
		Stack stack = new Stack();

		if(vertexSet.length != 0){
			String first = vertexSet[0].getName();
		
			visited.addLink(first);
			String current = first;
			stack.push(first);

			do{
				String[] adjacents = getAdjacents(current);
				for(int i = 0; i < adjacents.length; i++){
					 if(!visited.findValue(adjacents[i])){
					 	stack.push(adjacents[i]);
					 	visited.addLink(adjacents[i]);
					 	current = adjacents[i];
					 	break;
					 }
					 else if(i == adjacents.length-1){
					 	System.out.println("--");
					 	if(stack.peek() != null){
					 		stack.pop();
					 		current = stack.peek();
					 	}
					 	break;
					 }
				}
			}while(stack.peek() != null);
		}

		return visited.getList();
	}

	public String[] breadthFirst(){
		LinkList visited = new LinkList();
		Queue queue = new Queue();

		if(vertexSet.length != 0){
			String first = vertexSet[0].getName();
		
			visited.addLink(first);
			String current = first;
			queue.enqueue(first);

			do{
				current = queue.dequeue();
				String[] adjacents = getAdjacents(current);
				for(int i = 0; i < adjacents.length; i++){
					 if(!visited.findValue(adjacents[i])){
						queue.enqueue(adjacents[i]);
						visited.addLink(adjacents[i]);
					}
				}
			}while(!queue.isEmpty());
		}

		return visited.getList();
	}
}