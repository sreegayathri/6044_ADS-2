import java.util.*;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
    /**. Don't modify this method. */
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash =
                        loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }
    /**.
     * to read the give file.
     * { function_description }
     *
     * @param      file  The file
     * @return     { description_of_the_return_value }
     */
    public static String[] toReadFile(final String file) {
    //Don't modify this method.
        In in = new In(file);
        return in.readAllStrings();
    }
/**
 * Loads a dictionary.
 * time complexity O(n).
 * @param      file  The file.
 * @return     to read words into a dictionary using bst.
 */
    public static BinarySearchST<String, Integer>
                    loadDictionary(final String file) {
        BinarySearchST<String, Integer> st =
                    new BinarySearchST<String, Integer>();
        // your code goes here
        // for (int i = 0; !StdIn.isEmpty(); i++) {
        //     String key = StdIn.readString();
        //     st.put(key, i);
        // }
        // for (String words : st.keys()) {
        //     System.out.println(st.get(words));
        // }
        String[] text = toReadFile(file);
        for (String words : text) {
            words = words.toLowerCase();
            if (st.contains(words)) {
                st.put(words, st.get(words) + 1);
            } else {
                st.put(words, 1);
            }
        }
        return st;
    }

}

