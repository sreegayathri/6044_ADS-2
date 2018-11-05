import java.util.Scanner;
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
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
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