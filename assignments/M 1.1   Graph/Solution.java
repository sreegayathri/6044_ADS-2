import java.util.Scanner;
/**
 * Class for graphmatrix.
 */
class Graphmatrix implements Graph {
    /**
     * place list.
     */
    private String[] place;
    /**
     * matix.
     */
    private int[][] matrix;
    /**
     * no of vertices.
     */
    private int vertex;
    /**
     * edges count.
     */
    private int edge;
    /**
     * Constructs the object.
     *
     * @param      v     { parameter_description }
     * @param      e     { parameter_description }
     * @param      c     { parameter_description }
     */
    Graphmatrix(final int v, final int e, final String[] c) {
        place = c;
        matrix = new int[v][v];
        this.vertex = v;
        this.edge = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                matrix[i][j] = 0;
            }

        }
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (v == w || hasEdge(v, w)) {
            return;
        }
        matrix[v][w] = 1;
        matrix[w][v] = 1;
        edge++;
    }
    /**
     * adj.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int[] adj(final int v) {
        return matrix[v];
    }
    /**
     * no of vertices.
     *
     * @return     { description_of_the_return_value }
     */
    public int vertices() {
        return this.vertex;
    }
    /**
     * no of edges.
     *
     * @return     { description_of_the_return_value }
     */
    public int edges() {
        return this.edge;
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        return matrix[v][w] == 1;
    }
    /**
     * prints.
     */
    public void print() {
        if (edge == 0) {
            System.out.println("No edges");
        } else {
            for (int i = 0; i < vertex - 1; i++) {
                String s = "";
                for (int each : matrix[i]) {
                    s += each + " ";
                }
                System.out.println(s);
            }
            String s = "";
            for (int each : matrix[vertex - 1]) {
                s += each + " ";
            }
            System.out.println(s.substring(0, s.length() - 1));
        }
    }
}
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * no of vertices.
     *
     * @return     { description_of_the_return_value }
     */
    int vertices();
    /**
     * no of edges.
     *
     * @return     { description_of_the_return_value }
     */
    int edges();
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**
 * Class for graphList.
 */
class GraphList implements Graph {
    /**
     * vities list.
     */
    private String[] place;
    /**
     * no of vertices.
     */
    private int vertex;
    /**
     * no of edges.
     */
    private int edge;
    /**
     * ajacents list.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      v     { parameter_description }
     * @param      e     { parameter_description }
     * @param      c     { parameter_description }
     */
    GraphList(final int v, final int e, final String[] c) {
        place = c;
        this.vertex = v;
        this.edge = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (v == w || hasEdge(v, w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
        edge++;
    }
    /**
     * adj.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * no of vertice.
     *
     * @return     { description_of_the_return_value }
     */
    public int vertices() {
        return this.vertex;
    }
    /**
     * no of edges.
     *
     * @return     { description_of_the_return_value }
     */
    public int edges() {
        return this.edge;
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int each : adj[v]) {
            if (each == w) {
                return true;
            }
        }
        return false;
    }
    /**
     * prints.
     */
    public void print() {
        if (edge == 0) {
            System.out.println("No edges");
        } else {
            for (int i = 0; i < vertex - 1; i++) {
                String str = "";
                str += place[i] + ": ";
                for (int each : adj[i]) {
                    str += place[each] + " ";
                }
                System.out.println(str);
            }
            String str = "";
            str += place[vertex - 1] + ": ";
            for (int each : adj[vertex - 1]) {
                str += place[each] + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // empty constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String way = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        String[] place = sc.nextLine().split(",");
        if (way.equals("List")) {
            GraphList l = new GraphList(v, e, place);
            for (int k = 0; k < e; k++) {
                String[] tokens = sc.nextLine().split(" ");
                l.addEdge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]));
            }
            System.out.println(l.vertices()
                + " vertices, " + l.edges() + " edges");
            l.print();
        } else {
            Graphmatrix m = new Graphmatrix(v, e, place);
            for (int k = 0; k < e; k++) {
                String[] tokens = sc.nextLine().split(" ");
                m.addEdge(Integer.parseInt(tokens[0]),
                     Integer.parseInt(tokens[1]));
            }
            System.out.println(m.vertices()
                + " vertices, " + m.edges() + " edges");
            m.print();
        }
    }
}