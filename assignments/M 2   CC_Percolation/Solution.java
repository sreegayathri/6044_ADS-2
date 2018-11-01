import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // Unused Constructor.
    }
    /**
     * {main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        Percolation per = new Percolation(size);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            per.open(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
        }
        System.out.println(per.percolates());
    }
}