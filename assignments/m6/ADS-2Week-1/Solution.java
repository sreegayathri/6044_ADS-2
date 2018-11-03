import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
    /**
     * { var_description }.
     */
    private double[] rank;
    /**
     * Constructs the object.
     *
     * @param      g     { parameter_description }
     */
    PageRank(Digraph g) {
        rank = new double[g.V()];
        for (int i = 0; i < g.V(); i++) {
            rank[i] = 1.0 / (double)(g.V());
        }
        for (int k = 0; k < 1000; k++) {
            rank = prcal(rank, g);
        }
    }
    public double[] prcal(double[] list, Digraph g) {
        double[] rlist = new double[g.V()];
        for (int i = 0; i < g.V(); i++) {
            double pr = 0.0;
            for (int j = 0; j < g.V(); j++) {
                for (int each : g.adj(j)) {
                    if (each == i) {
                        pr += list[j] / (double)g.outdegree(j);
                    }
                }
            }
            rlist[i] = pr;
        }
        return rlist;
    }
    /**
     * Gets the pr.
     *
     * @param      v     { parameter_description }
     *
     * @return     The pr.
     */
    public double getPR(int v) {
        return rank[v];
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String print() {
        String str = "";
        for (int i = 0; i < rank.length; i++) {
            str += i + " - " + rank[i] + "\n";
        }
        return str;
    }
}
// /**
//  * Class for web search.
//  */
// class WebSearch {
//     /**
//      * { LinearProbingHashST }.
//      */
//     LinearProbingHashST<String, Integer> ht;
//     /**
//      * Constructs the object.
//      *
//      * @param      pr        { parameter_description }
//      * @param      filename  The filename
//      */
//     WebSearch(PageRank pr, String filename) {
//     }
//     public int ​iAmFeelingLucky​​(String query) {
        
//     }
// }


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // read the first line of the input to get the number of vertices
        int n = Integer.parseInt(sc.nextLine());
        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph
        Digraph di = new Digraph(n);
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            for (int v = 1 ; v < tokens.length ; v++) {
                di.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[v]));
            }
        }
        System.out.println(di);
        // Create page rank object and pass the graph object to the constructor
        for (int i = 0; i < di.V(); i++) {
            if (di.outdegree(i) == 0) {
                for (int k = 0; k < di.V(); k++) {
                    di.addEdge(i, k);
                }
            }
        }
        PageRank pr = new PageRank(di);
        // print the page rank object
        System.out.println(pr);
        // This part is only for the final test case
        //
        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object and the file path to the constructor

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky
    }
}