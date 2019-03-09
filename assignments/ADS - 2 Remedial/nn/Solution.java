import java.util.Scanner;
public final class Solution {
    private String[] root;
    /**
     * Constructs the object.
     */
    private Solution() {
        // unused
    }
    /**
     * Gets the index.
     *
     * @param      str   The string
     *
     * @return     The index.
     */
    private int getIndex(final String str) {
        int index = 0;
        for (int i = 0; i < root.length; i++) {
            if (str.equals(root[i])) {
                index = i;
            }
        }
        return index;
    }


    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Solution sol = new Solution();
        Scanner scan = new Scanner(System.in);
        String[] lines = scan.nextLine().split(" ");
        int circles  = Integer.parseInt(lines[0]);
        int routes  = Integer.parseInt(lines[1]);
        EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(circles);
        while (scan.hasNextLine()) {
            String[] route = scan.nextLine().split(" ");
            Edge edg = new Edge(Integer.parseInt(route[0]) - 1, Integer.parseInt(route[1]) - 1, Double.parseDouble(route[2]));
            ewgraph.addEdge(edg);
        }
        while (scan.hasNextLine()) {
            String[] tokens1 = scan.nextLine().split(" ");
            int home = sol.getIndex(tokens1[0]);
            SP l = new SP(ewgraph, home);
            int destination = sol.getIndex(tokens1[1]);
            System.out.printf("%d\n", (int) l.distTo(destination));
        }
    }
}