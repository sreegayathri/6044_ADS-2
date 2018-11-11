public class SAP {

    Digraph graph;
    int ancestor;
    int distance;
    BreadthFirstDirectedPaths bfsV;
    BreadthFirstDirectedPaths bfsW;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph graph) {
        this.graph = graph;
        ancestor = -1;
        distance = Integer.MAX_VALUE;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        return (distance == Integer.MAX_VALUE) ? -1 : distance;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        bfsV = new BreadthFirstDirectedPaths(graph, v);
        bfsW = new BreadthFirstDirectedPaths(graph, w);
        distance = Integer.MAX_VALUE;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                if (distance >= (bfsV.distTo(i) + bfsW.distTo(i))) {
                    distance = bfsV.distTo(i) + bfsW.distTo(i);
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        return (distance == Integer.MAX_VALUE)? -1 : distance;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        int nopath = -1;
        int length = Integer.MAX_VALUE;
        for (int i1 : v) {
            for (int i2 : w) {
                int ancestor = ancestor(i1, i2);
                if (length >= length(i1, i2)) {
                    length = distance;
                    nopath = ancestor;
                }
            }
        }
        distance = length;
        return nopath;
    }
}