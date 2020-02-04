public class Triangle
{
	void triangle(int k){
		for(int i = 1; i <= k; i++){
			for(int j = 0; j < k-i; j++){
				System.out.print(" ");
			}
			for(int l = 0; l < i; l++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Triangle t = new Triangle();
		t.triangle(10);
	}
}

