//import java.io.File;
/**
 * { importing scanner }.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String synsetsFile = sc.nextLine();
        String hypernymFile = sc.nextLine();
        String line = sc.nextLine();
        WordNet wordNet = new WordNet("Files/" + synsetsFile, 
            "Files/" + hypernymFile);
/*        try {
            File file =
                new File("Files//synsets.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch(Exception e) { }
        try {
            Files files =
                new Files("Files//hypernyms.txt")
        }*/
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