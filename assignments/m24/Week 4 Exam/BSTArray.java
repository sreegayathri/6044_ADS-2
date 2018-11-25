import java.util.Scanner;
/**
 * Class for bst array.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class IfArray<Key extends Comparable<Key>, Value> {
    /**. key array */
    private Key[] keys;
    /**. value array */
    private Value[] values;
    /**. size array */
    private int[] size;
    /**. ltlink  array */
    private int[] ltLinks;
    /**. rtlink  array */
    private int[] rtLinks;
    /**
     * Constructs the object.
     * @param size  The size
     */
    IfArray(int size) {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
        this.size = new int[size];
        ltLinks = new int[size];
        rtLinks = new int[size];
        for (int i = 0; i < size; i++) {
            ltLinks[i] = -1;
            rtLinks[i] = -1;
        }
    }
    /**
     * size.
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(0);
    }
    /**
     * helper method for size.
     * @param      index  The index
     * @return     { description_of_the_return_value }
     */
    private int size(int index) {
        if (index == -1) {
            return 0;
        }
        return size[index];
    }
    /**
     * min method.
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        if (size() == 0) {
            System.out.println("Empty binary search tree");
        }
        int minIndex = min(0);
        return keys[minIndex];
    }
    /**
     * helper method min.
     * @param      index  The index
     * @return     { description_of_the_return_value }
     */
    private int min(int index) {
        if (ltLinks[index] == -1) {
            return index;
        }
        return min(ltLinks[index]);
    }
    /**
     * get method.
     * @param      key   The key
     * @return     { description_of_the_return_value }
     */
    public Value get(Key key) {
        return get(0, key);
    }
    /**
     * helper get method.
     * @param      index  The index
     * @param      key    The key
     * @return     { description_of_the_return_value }
     */
    private Value get(int index, Key key) {
        if (index == -1 || keys[index] == null) {
            return null;
        }
        int cmp = key.compareTo(keys[index]);
        if (cmp < 0) {
            return get(ltLinks[index], key);
        } else if (cmp > 0) {
            return get(rtLinks[index], key);
        } else {
            return values[index];
        }
    }
    /**
     * put method.
     * @param      key    The key
     * @param      value  The value
     */
    public void put(Key key, Value value) {
        if (size() == keys.length) {
            System.out.println("Tree is full");
            return;
        }
        put(0, key, value);
    }
    /**
     * helper put method.
     * @param      index  The index
     * @param      key    The key
     * @param      value  The value
     * @return     { description_of_the_return_value }
     */
    private int put(int index, Key key, Value value) {
        if (index == -1 || keys[index] == null) {
            int addIndex = size();
            keys[addIndex] = key;
            values[addIndex] = value;
            size[addIndex] = 1;
            return addIndex;
        }
        int cmp = key.compareTo(keys[index]);
        if (cmp < 0) {
            ltLinks[index] = put(ltLinks[index], key, value);
        } else if (cmp > 0) {
            rtLinks[index] = put(rtLinks[index], key, value);
        } else {
            values[index] = value;
        }
        size[index] = size(ltLinks[index]) + 1 + size(rtLinks[index]);
        return index;
    }
    /**
     * delete method.
     * @param      key   The key
     */
    public void delete(Key key) {
        int rootIndex = delete(0, key);
    }
    /**
     * helper delete method.
     * @param      index  The index
     * @param      key    The key
     * @return     { description_of_the_return_value }
     */
    private int delete(int index, Key key) {
        if (index == -1 || keys[index] == null) {
            return -1;
        }
        int cmp = key.compareTo(keys[index]);
        if (cmp < 0) {
            int leftIndex = delete(ltLinks[index], key);
            ltLinks[index] = leftIndex;
        } else if (cmp > 0) {
            int rightIndex = delete(rtLinks[index], key);
            rtLinks[index] = rightIndex;
        } else {
            keys[index] = null;
            values[index] = null;
            size[index] = 0;
            if (ltLinks[index] == -1) {
                int rightIndex = rtLinks[index];
                rtLinks[index] = -1;
                return rightIndex;
            } else if (rtLinks[index] == -1) {
                int leftIndex = ltLinks[index];
                ltLinks[index] = -1;
                return leftIndex;
            } else {
                int next = min(rtLinks[index]);
                rtLinks[next] = deleteMin(rtLinks[index], false);
                ltLinks[next] = ltLinks[index];
                rtLinks[index] = -1;
                ltLinks[index] = -1;
                index = next;
            }
        }
        size[index] = size(ltLinks[index]) + 1 + size(rtLinks[index]);
        return index;
    }
    /**
     * deleteMin.
     */
    public void deleteMin() {
        int rootIndex = deleteMin(0, true);
    }
    /**
     * helper deleteMin.
     * @param      index  The index
     * @param      leaf   The leaf
     * @return     { description_of_the_return_value }
     */
    private int deleteMin(int index, boolean leaf) {
        if (index == -1 || keys[index] == null) {
            return -1;
        }
        int leftIndex = deleteMin(ltLinks[index], leaf);
        ltLinks[index] = leftIndex;
        size[index] = size(ltLinks[index]) + 1 + size(rtLinks[index]);
        return index;
    }
}
/**
 * Class for bst array.
 */
class BSTArray {
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int element = scan.nextInt();
        IfArray<Integer, String> bst = new IfArray<>(element);
        Stopwatch time = new Stopwatch();
        while (element > 0) {
            String s = scan.nextLine();
            String[] tokens = s.split(" ");
            switch (tokens[0]) {
            case"put":
                bst.put(Integer.parseInt(tokens[1]), tokens[2]);
                // System.out.println(time.elapsedTime());
                break;
            case"get":
                String val = bst.get(Integer.parseInt(tokens[1]));
                System.out.println(val);
                // System.out.println(time.elapsedTime());
                break;
            case"delete":
                bst.delete(Integer.parseInt(tokens[1]));
                // System.out.println(time.elapsedTime());
            }
            element--;
        }
        System.out.println(time.elapsedTime());
    }
}