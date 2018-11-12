import java.util.Scanner;
// import java.lang.StringBuilder;
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
        int digit = Integer.parseInt(sc.nextLine());
        String[] strings = new String[digit];
        for (int i = 0; i < digit; i++) {
            strings[i] = sc.nextLine();
        }
        Quick3way.sort(strings);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j < digit - 1; j++) {
            sb.append(strings[j]);
            sb.append(", ");
        }
        sb.append(strings[digit - 1]);
        sb.append("]");
        System.out.println(sb.toString());

    }
}
