import java.util.Scanner;
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
/**
 * Class for t 9.
 */
class T9 {
    /**.
     * TST object.
     */
    private TST<Integer> text;
    /**.
     * Constructs the object.
     * @param      st    { parameter_description }
     */
    public T9(BinarySearchST<String, Integer> st) {
        // your code goes here
        text = new TST();
        for (String word : st.keys()) {
            text.put(word, st.get(word));
        }

    }
    /**.
     * Gets all words.
     * get all the prefixes that match with given prefix.
     * @param      prefix  The prefix
     *
     * @return     All words.
     */
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        // TST text = new TST();
        return text.keysWithPrefix(prefix);
    }
    /**.
     * { function_description }
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here
        return null;
    }

    /**.
     * Gets the suggestions.
     * return all possibilities(words), find top k with highest frequency;
     *
     * @param      words  The words
     * @param      k      { parameter_description }
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(final Iterable<String> words,
                                final int k) {
        // your code goes here
        // StringBuilder sequence = new StringBuilder();
        // for (char c : text.toCharArray())
        //     sequence.append(getDigit(c));
        // return sequence.toString();
        return null;
    }
// /**
//  * Gets the digit.
//  * @param      alphabet  The alphabet
//  * @return     The digit.
//  */
//     public static char getDigit(char alphabet) {
//         if (alphabet >= '0' && alphabet <= '9') {
//             return alphabet;
//         }
//         switch (alphabet) {
//         case 'a':
//         case 'b':
//         case 'c':
//             return '2';
//         case 'd':
//         case 'e':
//         case 'f':
//             return '3';
//         case 'g':
//         case 'h':
//         case 'i':
//             return '4';
//         case 'j':
//         case 'k':
//         case 'l':
//             return '5';
//         case 'm':
//         case 'n':
//         case 'o':
//             return '6';
//         case 'p':
//         case 'q':
//         case 'r':
//         case 's':
//             return '7';
//         case 't':
//         case 'u':
//         case 'v':
//             return '8';
//         case 'w':
//         case 'x':
//         case 'y':
//         case 'z':
//             return '9';
//         default:
//             return '1';
//         }
//     }
    //final output
    //Don't modify this method.
    /**.
     * { function_description }
     * @param      t9Signature  The t 9 signature
     * @param      k            { parameter_description }
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> t9(final String t9Signature, final int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
