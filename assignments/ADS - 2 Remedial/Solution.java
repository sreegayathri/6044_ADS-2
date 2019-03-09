import java.util.Scanner;
class Solution {
    Solution() {
        //
    }
    public static void main(String[] args) {
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
        KruskalMST krush = new KruskalMST(ewgraph);
        System.out.format("%.0f", krush.weight());
        System.out.println("");
        for (Edge e : ewgraph.edges()) {
            int  vertex = e.either();
            int edge = e.other(vertex);
            int x  = vertex +1;
            int y = edge + 1;
            System.out.println(e);        
        }
    }
}