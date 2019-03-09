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
        for (int i = 1; i < routes-1; i++) {
            String[] route = scan.nextLine().split(" ");
            Edge edg = new Edge(Integer.parseInt(route[0]),Integer.parseInt(route[1]),Integer.parseInt(route[2]));
            ewgraph.addEdge(edg);
        }
        KruskalMST krush = new KruskalMST(ewgraph);
        System.out.format("%d", krush.weight());
    }
}