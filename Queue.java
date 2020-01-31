public class Queue
{
	private Stack stack1 = new Stack();
	private Stack stack2 = new Stack();

	public void enqueue(String value){
		stack1.push(value);
	}

	public String dequeue(){		
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		
		String str = stack2.pop();

		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return str;
	}

	public boolean isEmpty(){
		return stack1.isEmpty();
	}
}