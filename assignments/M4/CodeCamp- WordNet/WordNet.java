import java.util.ArrayList;

/**
 * Class for word net.
 */
public class WordNet {
    /**
     * Hash table to store items.
     */
    LinearProbingHashST<String, Integer> ht;
    /**
     * graph which is directed.
     */
    Digraph graph;
    /**
     * sap object.
     */
    private SAP sap;
    /**
     * arraylist object.
     */
    private ArrayList<String> alist;
    /**
     * { function_description }
     *
     * @param      synsets  The synsets
     *
     * @return     { description_of_the_return_value }
     */
    private int processSynsets(String synsets) {
        In in = new In(synsets);
        int count = 0;
        ht = new LinearProbingHashST<String, Integer>();
        while (!in.isEmpty()) {
            String[] tokens = in.readLine().split(",");
            String[] nouns = tokens[1].split(" ");
            for (String noun : nouns) {
                ht.put(noun, Integer.parseInt(tokens[0]));
            }
            count++;
        }
        return count;
    }

    private Digraph buildGraph(String hypernyms, int count) {
        Digraph graph = new Digraph(count);
        In in = new In(hypernyms);
        while (!in.isEmpty()) {
            String[] tokens = in.readLine().split(",");
            for (int i = 1; i < tokens.length; i++) {
                graph.addEdge(Integer.
                              parseInt(tokens[0]), Integer.
                              parseInt(tokens[i]));
            }
        }
        return graph;
    }
    public boolean multipleRoot(Digraph graph) {
        int count = 0;
        for (int i = 0; i < graph.V(); i++) {
            if (graph.outdegree(i) == 0) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }
    public void printGraph() {
        DirectedCycle directedcycle = new DirectedCycle(graph);
        if (directedcycle.hasCycle()) {
            System.out.println("Cycle detected");
            return;
        } else if  (!multipleRoot(graph)) {
            System.out.println("Multiple roots");
            return;
        }
        System.out.println(graph);
    }

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        int count = processSynsets(synsets);
        graph = buildGraph(hypernyms, count);
        // printGraph();
        // System.out.println("Count = " + count);
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return ht.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return ht.contains(word);
    }
    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        return sap.length(ht.get(nounA), ht.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        int ancestor = sap.ancestor(ht.get(nounA), ht.get(nounB));
        return alist.get(ancestor);
    }

    public void processQuery(String query) {
        String[] tokens = query.split(" ");
        String str = "";
        if (isNoun(tokens[0]) && isNoun(tokens[1])) {
            sap = new SAP(graph);
            str = sap(tokens[0], tokens[1]);
            int distance = distance(tokens[0], tokens[1]);
            System.out.println("distance = " + distance + ", ancestor = " + str);
        }
    }
}
