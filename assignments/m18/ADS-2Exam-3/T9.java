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
    public T9(final BinarySearchST<String, Integer> st) {
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