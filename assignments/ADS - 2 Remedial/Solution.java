import java.util.Scanner;
import java.lang.IllegalArgumentException;
/**
 * Class for solution.
 * @author sreegayathri.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int vertices = Integer.parseInt(line[0]);
        int edges = Integer.parseInt(line[1]);
        EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(vertices);
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            Edge edg = new Edge(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]), Double.parseDouble(input[2]));
            ewgraph.addEdge(edg);
        }
        KruskalMST krush = new KruskalMST(ewgraph);
        System.out.format("%.5f", krush.weight());
    }
}
