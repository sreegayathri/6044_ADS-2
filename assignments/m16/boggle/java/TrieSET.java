import java.util.Iterator;
/**
 *  The TrieSET class represents an ordered set of strings over
 *  the extended ASCII alphabet.
 *  It supports the usual add, contains, and delete
 *  methods. It also provides character-based methods for finding the string
 *  in the set that is the longest prefix of a given prefix,
 *  finding all strings in the set that start with a given prefix,
 *  and finding all strings in the set that match a given pattern.
 *  This implementation uses a 26-way trie.
 *  The add, contains, delete, and
 *  longest prefix methods take time proportional to the length
 *  of the key (in the worst case). Construction takes constant time.
 *  For additional documentation, see
 *  <a href="http://algs4.cs.princeton.edu/52trie">Section 5.2</a> of
 *  <i>Algorithms in Java, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class TrieSET implements Iterable<String> {
    private static final int R = 26;        // extended ASCII

    private Node root;      // root of trie
    private int N;          // number of keys in trie

    // R-way trie node
    private static class Node {
        private Node[] next = new Node[R];
        private boolean isString;
    }

    /**
     * Initializes an empty set of strings.
     */
    public TrieSET() {
    }

    /**
     * Does the set contain the given key?
     * @param key the key
     * @return true if the set contains key and false otherwise
     * @throws NullPointerException if key is null
     */
    public boolean contains(String key) {
        Node x = get(root, key, 0);
        if (x == null) return false;
        return x.isString;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = Character.toUpperCase(key.charAt(d));
        return get(x.next[c - 'A'], key, d+1);
    }

    /**
     * Adds the key to the set if it is not already present.
     * @param key the key to add
     * @throws NullPointerException if key is null
     */
    public void add(String key) {
        root = add(root, key, 0);
    }

    private Node add(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (!x.isString) N++;
            x.isString = true;
        }
        else {
            char c = Character.toUpperCase(key.charAt(d));
            x.next[c - 'A'] = add(x.next[c - 'A'], key, d+1);
        }
        return x;
    }

    /**
     * Returns the number of strings in the set.
     * @return the number of strings in the set
     */
    public int size() {
        return N;
    }

    /**
     * Is the set empty?
     * @return True if the set is empty, and false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns all of the keys in the set, as an iterator.
     * To iterate over all of the keys in a set named set, use the
     * foreach notation: for (Key key : set).
     * @return an iterator to all of the keys in the set
     */
    public Iterator<String> iterator() {
        return keysWithPrefix("").iterator();
    }

    /**
     * Returns all of the keys in the set that start with <tt>prefix</tt>.
     * @param prefix the prefix
     * @return all of the keys in the set that start with <tt>prefix</tt>,
     *     as an iterable
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> results = new Queue<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if (x == null) return;
        if (x.isString) results.enqueue(prefix.toString());
        for (char c = 'A'; c < 'A' + R; c++) {
            prefix.append(c);
            collect(x.next[c - 'A'], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /**
     * Returns all of the keys in the set that match <tt>pattern</tt>,
     * where . symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the set that match <tt>pattern</tt>,
     *     as an iterable, where . is treated as a wildcard character.
     */  
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> results = new Queue<String>();
        StringBuilder prefix = new StringBuilder();
        collect(root, prefix, pattern, results);
        return results;
    }
        
    private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
        if (x == null) return;
        int d = prefix.length();
        if (d == pattern.length() && x.isString)
            results.enqueue(prefix.toString());
        if (d == pattern.length())
            return;
        char c = Character.toUpperCase(pattern.charAt(d));
        if (c == '.') {
            for (char ch = 'A'; ch < 'A' + R; ch++) {
                prefix.append(ch);
                collect(x.next[ch - 'A'], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        else {
            prefix.append(c);
            collect(x.next[c - 'A'], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /**
     * Returns the string in the set that is the longest prefix of <tt>query</tt>,
     * or <tt>null</tt>, if no such string.
     * @param query the query string
     * @throws NullPointerException if <tt>query</tt> is <tt>null</tt>
     * @return the string in the set that is the longest prefix of <tt>query</tt>,
     *     or <tt>null</tt> if no such string
     */
    public String longestPrefixOf(String query) {
        int length = longestPrefixOf(root, query, 0, -1);
        if (length == -1) return null;
        return query.substring(0, length);
    }

    // returns the length of the longest string key in the subtrie
    // rooted at x that is a prefix of the query string,
    // assuming the first d character match and we have already
    // found a prefix match of length length
    private int longestPrefixOf(Node x, String query, int d, int length) {
        if (x == null) return length;
        if (x.isString) length = d;
        if (d == query.length()) return length;
        char c = Character.toUpperCase(query.charAt(d));
        return longestPrefixOf(x.next[c - 'A'], query, d+1, length);
    }

    /**
     * Removes the key from the set if the key is present.
     * @param key the key
     * @throws NullPointerException if <tt>key</tt> is <tt>null</tt>
     */
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            if (x.isString) N--;
            x.isString = false;
        }
        else {
            char c = key.charAt(d);
            x.next[c - 'A'] = delete(x.next[c - 'A'], key, d+1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.isString) return x;
        for (int c = 'A'; c < 'A' + R; c++)
            if (x.next[c - 'A'] != null)
                return x;
        return null;
    }

    public boolean hasPrefix(String query) {
        Node x = get(root, query, 0);
        return x != null;
    }


    // /**
    //  * Unit tests the <tt>TrieSET</tt> data type.
    //  */
    // public static void main(String[] args) {
    //     TrieSET set = new TrieSET();
    //     while (!StdIn.isEmpty()) {
    //         String key = StdIn.readString();
    //         set.add(key);
    //     }

    //     // print results
    //     if (set.size() < 100) {
    //         StdOut.println("keys(\"\"):");
    //         for (String key : set) {
    //             StdOut.println(key);
    //         }
    //         StdOut.println();
    //     }

    //     StdOut.println("longestPrefixOf(\"SHELLSORT\"):");
    //     StdOut.println(set.longestPrefixOf("SHELLSORT"));
    //     StdOut.println();

    //     StdOut.println("longestPrefixOf(\"XSHELLSORT\"):");
    //     StdOut.println(set.longestPrefixOf("XSHELLSORT"));
    //     StdOut.println();

    //     StdOut.println("keysWithPrefix(\"SHOR\"):");
    //     for (String s : set.keysWithPrefix("SHOR"))
    //         StdOut.println(s);
    //     StdOut.println();

    //     StdOut.println("keysWithPrefix(\"SHORTENING\"):");
    //     for (String s : set.keysWithPrefix("SHORTENING"))
    //         StdOut.println(s);
    //     StdOut.println();

    //     StdOut.println("keysThatMatch(\".HE.L.\"):");
    //     for (String s : set.keysThatMatch(".HE.L."))
    //         StdOut.println(s);
    //     StdOut.println();

    //     StdOut.println("hasPrefix(\"SHOR\")");
    //     StdOut.println(set.hasPrefix("SHOR"));
    // }
}