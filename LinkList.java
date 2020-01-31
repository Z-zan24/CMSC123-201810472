public class LinkList
{
	private Link first;
	private String name;

	public LinkList(){
		name = null;
	}

	public LinkList(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public Link getFirst(){
		return first;
	}

	public void addLink(String value){
		Link newLink = first;
		first = new Link();
		first.setNext(newLink);
		if(newLink == null){
			first.setLink(value, 0);
		}
		else{
			first.setLink(value, newLink.getLinkNum()+1);
		}
	}
	public void removeLink(String value){
		if(first != null){
			if(first.getContent().equals(value)){
				first = first.getNext();
			}
			else{
				first.removeLink(value);
			}
		}
	}
	public String removeTop(){
		Link temp = first;
		first = first.getNext();

		return temp.getContent();
	}
	public boolean isEmpty(){
		if(first == null){
			return true;
		}
		return false;
	}
	public String[] getList(){
		if(first == null){
			return null;
		}
		else{
			String[] contentList = new String[first.getLinkNum()+1];
			return first.getContentList(contentList);
		}
	}
	public boolean findValue(String value){
		if(first != null){
			return first.findValue(value);
		}
		return false;
	}
}