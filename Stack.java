public class Stack
{
	private LinkList list = new LinkList();

	public void push(String value){
		list.addLink(value);
	}

	public String pop(){
		return list.removeTop();
	}

	public String peak(){
		String temp = pop();
		push(temp);
		return temp;
	}
}