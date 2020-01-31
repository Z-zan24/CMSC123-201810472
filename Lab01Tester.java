import java.util.Scanner;

public class UGraphTester
{
	private UGraph ugraph = new UGraph();

	public UGraphTester(){
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		String value = new String();
		String value2 = new String();

		while(choice != 0){
			System.out.println("\n-----UGraph Tester-----");
			System.out.println("\nQueries:");
			System.out.println("\t1. Number of vertices");
			System.out.println("\t2. Number of edges");
			System.out.println("\t3. List vertices adjacent to...");
			System.out.println("\t4. Are adjacent?");
			System.out.println("\t5. Are connected?");
			System.out.println("\nModifications:");
			System.out.println("\t6. Insert edge");
			System.out.println("\t7. Remove edge");
			System.out.println("\t8. Insert vertex");
			System.out.println("\t9. Remove vertex");
			System.out.println("\n\t0. EXIT");

			System.out.print("\nEnter your choice: ");
			choice = scan.nextInt();
			scan.nextLine();

			switch(choice){
				case 1:
					System.out.println("\nNumber of vertices: " + ugraph.getVertexCount());
					break;
				case 2:
					System.out.println("\nNumber of edges: " + ugraph.getEdgeCount());
					break;
				case 3:
					System.out.print("Select a vertex: ");
					value = scan.nextLine();
					String[] contentList = ugraph.getAdjacents(value);
					System.out.print("\n" + value + ":");
					for(String c : contentList){
						System.out.print(" |" + c + "|");
					}
					break;
				case 4:
					System.out.println("Select two vertices");
					System.out.print("(1): ");
					value = scan.nextLine();
					System.out.print("(2): ");
					value2 = scan.nextLine();

					System.out.println("\nAre adjacent?: " + ugraph.isAdjacent(value, value2));
					break;
				case 5:
					System.out.println("Select two vertices");
					System.out.print("(1): ");
					value = scan.nextLine();
					System.out.print("(2): ");
					value2 = scan.nextLine();

					LinkList removed = new LinkList();

					System.out.println("\nAre connected?: " + ugraph.isConnected(removed , value, value2));
					break;
				case 6:
					System.out.println("Select two vertices");
					System.out.print("(1): ");
					value = scan.nextLine();
					System.out.print("(2): ");
					value2 = scan.nextLine();

					ugraph.insertEdge(value, value2);

					System.out.println("\nAn edge has been added between " + value + " and " + value2 + "!");
					break;
				case 7:
					System.out.println("Select two vertices");
					System.out.print("(1): ");
					value = scan.nextLine();
					System.out.print("(2): ");
					value2 = scan.nextLine();

					ugraph.removeEdge(value, value2);

					System.out.println("\nThe edge between " + value + " and " + value2 + " has been removed!");
					break;
				case 8:
					System.out.print("Enter a vertex: ");
					value = scan.nextLine();
			
					ugraph.insertVertex(value);

					System.out.println("\nVertex " + value + " has been added!");
					break;
				case 9:
					System.out.print("Enter a vertex: ");
					value = scan.nextLine();
			
					ugraph.removeVertex(value);

					System.out.println("\nVertex " + value + " has been removed!");
					break;
			}
		}
	}

	public static void main(String[] args){
		new UGraphTester();
	}
}