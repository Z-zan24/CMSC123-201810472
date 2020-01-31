public class Stack
{
	private LinkList list = new LinkList();

	public void push(String value){
		list.addLink(value);
	}

	public String pop(){
		return list.removeTop();
	}

	public String peek(){
		String temp = pop();
		push(temp);
		return temp;
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}
}