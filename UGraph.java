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

	public boolean isConnected(String a, String b){
		for(int i = 0; i < vertexSet.length; i++){
			if(vertexSet[i].getName().equals(a)){
				if(vertexSet[i].findValue(b)){
					return true;
				}
				else{
					String[] adjacents = vertexSet[i].getList();

					/*if(adjacents != null){
						String[] temp = new String[adjacents.length-1];
						int l = 0;

						if(temp.length > 0){
							for(int k = 0; k < adjacents.length; k++){
								if(adjacents[k].equals(a)){
									continue;
								}
								temp[l++] = adjacents[k];
							}
						}

						adjacents = temp;*/

						for(int j = 0; j < adjacents.length; j++){
							if(isConnected(adjacents[j], b)){
								return true;
							}
						}
					//}
					return false;
				}
			}
		}
		return false;
	}
}