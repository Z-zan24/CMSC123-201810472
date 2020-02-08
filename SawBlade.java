public class SawBlade
{
	public void sawBlade(int k){
		for(int i = 1; i <= k; i++){
			for(int j = i; j > 0; j--){
				for(int l = 0; l < j; l++){
					System.out.print("*");
				}
				for(int m = 0; m < k-i; m++){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		SawBlade s = new SawBlade();

		s.sawBlade(10);
	}
}