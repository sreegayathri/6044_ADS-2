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

        for (int i = 0; i < k; i++) {
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

            int x = Integer.parseInt(sc.next());
            int y = Integer.parseInt(sc.next());
            int z = Integer.parseInt(sc.next());
            DijkstraSP source1 = new DijkstraSP(graph1, x);
            DijkstraSP source2 = new DijkstraSP(graph1, y);
            double weight1 = source1.distTo(y);
            double weight2 = source2.distTo(z);
            if (weight1 == Double.POSITIVE_INFINITY || weight2 == Double.
                    POSITIVE_INFINITY) {
                System.out.println("No Path Found.");
            } else {
                double res = weight1 + weight2;
                System.out.println(res);
            
            StringBuffer sb = new StringBuffer();
            sb.append(x+" ");
            for (DirectedEdge e : source1.pathTo(y)) {
                sb.append(e.to() + " ");
            }
            for (DirectedEdge e : source2.pathTo(z)) {
                sb.append(e.to() + " ");
            }
            System.out.println(sb.toString()); 
                //    StringBuffer sb = new StringBuffer();
                //     sb.append(Integer.parseInt(point1[0]) + " ");
                //     for (Edge e : source1.pathTo
                //     (Integer.parseInt(point1[1]))) {
                //         sb.append(e.either() + " ");
                //     }
                //     for (Edge e : source2.pathTo
                //     (Integer.parseInt(point1[2]))) {
                //          v = e.other(v);
                //          sb.append(v + " ");
                //     }
                //     System.out.println(sb);
            }
            break;
        default:
            break;
        }

    }
}
