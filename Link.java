public class Link
{
	private int linkNum;
	private Link next;
	private String content;

	public void setNext(Link next){
		this.next = next;
	}

	public Link getNext(){
		return next;
	}

	public void setLink(String value, int linkNum){
		content = value;
		this.linkNum = linkNum;
	}

	public String getContent(){
		return content;
	}

	public int getLinkNum(){
		return linkNum;
	}

	public String[] getContentList(String[] contentList){
		if(next == null){
			contentList[linkNum] = content;
			return contentList;
		}
		else{
			contentList[linkNum] = content;
			return next.getContentList(contentList);
		}
	}

	public void removeLink(String value){
		if(next != null && next.getContent().equals(value)){
			next = next.getNext();	
		}
		else if(next != null){
			next.findValue(value);
		}
	}

	public boolean findValue(String value){
		if(value.equals(content)){
			return true;
		}
		else if(next == null){
			return false;
		}
		else{
			return next.findValue(value);
		}
	}
}