/**
 * Class for ConnectedComponents.
 */
public class ConnectedComponents {
    /**
     * marked[v] = has vertex v been marked.
     */
    private boolean[] marked;
    /**
     * id of connected component containing v.
     */
    private int[] id;
    /**
     * number of vertices in given component.
     */
    private int[] size;
    /**
     * number of connected components.
     */
    private int count;
    /**
     * Computes the connected components of the undirected graph {@code G}.
     *
     * @param gra the undirected graph
     */
    public ConnectedComponents(final Graph gra) {
        marked = new boolean[gra.abc()];
        id = new int[gra.abc()];
        size = new int[gra.abc()];
        for (int v = 0; v < gra.abc(); v++) {
            if (!marked[v]) {
                dfs(gra, v);
                count++;
            }
        }
    }
    /**
     * DFS of the Graph.
     *
     * @param      gra     Graph.
     * @param      v     Starting Vertex.
     */
    private void dfs(final Graph gra, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : gra.adj(v)) {
            if (!marked[w]) {
                dfs(gra, w);
            }
        }
    }
    /**
     * Returns the component.
     *
     * @param  v the vertex.
     * @return the component id.
     * @throws IllegalArgumentException unless {@code 0 <= v < V}.
     */
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }
    /**
     * Returns the number of vertices.
     *
     * @param  v the vertex
     * @return the number of vertices.
     * @throws IllegalArgumentException.
     */
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }
    /**
     * Returns the number of connected.
     *
     * @return the number of connected.
     */
    public int count() {
        return count;
    }
    /**
     * Returns true if vertices are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return if vertices and are in the same
     *         connected component; otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @throws IllegalArgumentException unless {@code 0 <= w < V}
     */
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    /**
     * Returns true if vertices are in the same
     * connected component.
     *
     * @param  v one vertex
     * @param  w the other vertex
     * @return if vertices and are in the same
     *         connected component; otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @throws IllegalArgumentException unless {@code 0 <= w < V}
     * @deprecated Replaced by {@link #connected(int, int)}.
     */
    @Deprecated
    public boolean areConnected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    /**
     * Validates the Vertex.
     *
     * @param      v     vertex
     */
    private void validateVertex(final int v) {
        int ver = marked.length;
        if (v < 0 || v >= ver) {
            throw new IllegalArgumentException("vertex " + v
                + " is not between 0 and " + (ver - 1));
        }
    }
}
