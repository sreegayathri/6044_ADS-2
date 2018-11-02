import java.util.Scanner;
class Solution {

	public static void readFile(String fileName) {
		In in = new In("\\Files\\" + fileName);
		while (!in.isEmpty()) {

		}
		System.out.println("After while loopp....");
 	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String synsetsFileName = scan.nextLine();
		String hypernymsFileName = scan.nextLine();
		synsetsFileName = "\\Files\\" + synsetsFileName;
		hypernymsFileName = "\\Files\\" + hypernymsFileName;
		WordNet wordNet = new WordNet(synsetsFileName, hypernymsFileName);
		String line = scan.nextLine();
		switch(line) {
			case "Graph":
			wordNet.printGraph();
			break;
			case "Queries":
			break;
			default:
			break;
		}
	}
}