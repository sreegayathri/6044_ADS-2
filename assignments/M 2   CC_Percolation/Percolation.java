/**
 * Class for percolation.
 */
class Percolation {
    /**
     * Graph of the Percolation.
     */
    private Graph graph;
    /**
     * Size of the matrix.
     */
    private int size;
    /**
     * Top-most node.
     */
    private int upper;
    /**
     * Bottom node.
     */
    private int lower;
    /**
     * Grid size.
     */
    private int gridSize;
    /**
     * Connected Grid.
     */
    private boolean[][] connected;
    /**
     * Opened Nodes.
     */
    private int opened;
    /**
     * Constructs the object.
     *
     * @param      s     Size of grid.
     */
    Percolation(final int s) {
        size = s;
        opened = 0;
        gridSize = size * size;
        upper = gridSize;
        lower = gridSize + 1;
        connected = new boolean[size][size];
        graph = new Graph(gridSize + 2);
    }
    /**
     * To open the components.
     *
     * @param      row     The row
     * @param      column  The column
     */
    public void open(final int row, final int column) {
        if (!isOpen(row, column)) {
            connected[row - 1][column - 1] = true;
            opened++;
        }
        if (row == 1) {
            graph.addEdge(getIndex(row, column), upper);
        }
        if (row == size) {
            graph.addEdge(getIndex(row, column), lower);
        }
        if (column > 1 && isOpen(row, column - 1)) {
            graph.addEdge(getIndex(row, column),
                getIndex(row, column - 1));
        }
        if (column < size && isOpen(row, column + 1)) {
            graph.addEdge(getIndex(row, column),
                getIndex(row, column + 1));
        }
        if (row > 1 && isOpen(row - 1, column)) {
            graph.addEdge(getIndex(row, column),
                getIndex(row - 1, column));
        }
        if (row < size && isOpen(row + 1, column)) {
            graph.addEdge(getIndex(row, column),
                getIndex(row + 1, column));
        }
    }
    /**
     * Determines if open.
     *
     * @param      row     The row
     * @param      column  The column
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int column) {
        return connected[row - 1][column - 1];
    }
    /**
     * Determines if full.
     *
     * @param      row     The row
     * @param      column  The column
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int row, final int column) {
        if (0 < row && row <= size && 0 < column && column <= size) {
            return graph.hasEdge(upper, getIndex(row, column));
        }
        return false;
    }
    /**
     * Count of opened sites.
     *
     * @return     Integer.
     */
    public int numberOfOpenSites() {
        return opened;
    }
    /**
     * To check if the grid percolates.
     *
     * @return     True if percolates, else false.
     */
    public boolean percolates() {
        ConnectedComponents c = new ConnectedComponents(graph);
        return c.connected(upper, lower);
    }
    /**
     * Gets the index.
     *
     * @param      row     The row
     * @param      column  The column
     *
     * @return     The index.
     */
    private int getIndex(final int row, final int column) {
        return size * (row - 1) + (column - 1);
    }
}