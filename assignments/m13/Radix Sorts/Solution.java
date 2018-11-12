import java.util.Scanner;
import java.lang.StringBuffer;
/**
 * class Solution.
 */
public final  class Solution {
/**
 * Constructs the object.
 */
    private Solution() { }
    /**
     * MAIN function of quick3way.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Quick3way q3w = new Quick3way();
        int digit = sc.nextInt();;
        sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digit; i++) {
            sb.append(sc.nextLine() + "::");
        }
        // sort the strings
        String[] lines = sb.toString().split("::");
        q3w.sort(lines);

        // print the results
        String str = "[";
        for (int i = 0; i < digit; i++) {
            str += lines[i] + ", ";
        }
        System.out.println(str.substring(0, str.length() - 2) + "]");
    }
}
