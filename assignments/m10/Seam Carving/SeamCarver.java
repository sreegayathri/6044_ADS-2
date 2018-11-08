/**
 * Class for seam carver.
 */
public class SeamCarver {
    // create a seam carver object based on the given picture
    /** pic object of Picture. */
    private Picture pic;
/**
 * { var_description }
 */private int height;
/**
 * { var_description }
 */private int width;
/**
 * { var_description }
 */private double[][] energy;
    /**
     * Constructs the object.
     *
     * @param      picture  The picture
     */
    public SeamCarver(Picture picture) {
        this.pic = pic;
        this.width = pic.width();
        this.height = pic.height();
        this.energy = new double[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height ; j++) {
                if (i == 0 || j == 0 || i == width - 1 || j == height - 1) {
                    energy[i][j] = 1000.0;
                }
            }
        }
    }
    // current picture
    public Picture picture() {
        return pic;
    }
    // width of current picture
    public int width() {
        return width;
    }

    // height of current picture
    public int height() {
        return height;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        return 0;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        return new int[0];
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return new int[0];
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {

    }
}