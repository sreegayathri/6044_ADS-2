import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
/**
 * { function_description }
 *
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph graph = new EdgeWeightedGraph(n);
        EdgeWeightedDigraph graph1 = new EdgeWeightedDigraph(n);
        for(int i = 0; i < k; i++) {
            String[] tokens = sc.nextLine().split(" ");
            graph.addEdge(new Edge(Integer.
                parseInt(tokens[0]), Integer.
                parseInt(tokens[1]), Double.
                parseDouble(tokens[2])));
            graph1.addEdge(new DirectedEdge(Integer.
                parseInt(tokens[0]), Integer.
                parseInt(tokens[1]), Double.parseDouble(tokens[2])));
            graph1.addEdge(new DirectedEdge(Integer.
                parseInt(tokens[1]), Integer.
                parseInt(tokens[0]), Double.parseDouble(tokens[2])));
        }
        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            //Print the Graph Object.
            System.out.println(graph);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] point = sc.nextLine().split(" ");
            DijkstraSP sp = new DijkstraSP(graph1, Integer.parseInt(point[0]));
            double weight = sp.distTo(Integer.parseInt(point[1]));
            if (weight != Double.POSITIVE_INFINITY) {
                System.out.println(weight);
            } else {
                System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."

            String[] point1 = sc.nextLine().split(" ");
            DijkstraSP source1 = new DijkstraSP(graph1, Integer.
                parseInt(point1[0]));
            DijkstraSP source2 = new DijkstraSP(graph1, Integer.
                parseInt(point1[1]));
            double weight1 = source1.distTo(Integer.parseInt(point1[1]));
            double weight2 = source2.distTo(Integer.parseInt(point1[2]));
            String str = point1[0] + " ";
            if (weight1 == Double.POSITIVE_INFINITY || weight2 == Double.
                POSITIVE_INFINITY) {
                System.out.println("No Path Found.");
            }
            break;
        default:
            break;
        }

    }
}
