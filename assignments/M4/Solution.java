import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
        // empty.
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String synsetsFile = scan.nextLine();
        String hypernymsFile = scan.nextLine();
        synsetsFile = "\\Files\\" + synsetsFile;
        hypernymsFile = "\\Files\\" + hypernymsFile;
        WordNet wordnet = new WordNet(synsetsFile, hypernymsFile);
        String line = scan.nextLine();
        switch (line) {
            case "Graph":
            wordnet.printGraph();
                break;
            case "Queries":
            // wordnet.printGraph();
            while(scan.hasNext()) {
                String[] tokens = scan.nextLine().split(" ");
                if (tokens[0].equals("null")) {
                    System.out.println("IllegalArgumentException");
                }
            }
                break;
            default:
                break;
        } 
    }
}