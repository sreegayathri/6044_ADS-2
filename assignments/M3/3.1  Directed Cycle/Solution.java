import java.util.Scanner;
/**
 * Class for Solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */

  private Solution() {
    /**
     * Unused.
     */
  }
  /**
   * Main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    Digraph di = new Digraph(scan);
    DirectedCycle cycle = new DirectedCycle(di);
    if (cycle.hasCycle()) {
      System.out.println("Cycle exists.");
    } else {
      System.out.println("Cycle doesn't exists.");
    }
  }
}
