import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * @author  tiiaan
 * @version 1.0
 */
public class Percolation {
    private final boolean[] state;
    private int n;
    private int openSitesCount;
    private final WeightedQuickUnionUF ufAct, ufVir;

    /**
     * Creates n-by-n grid, with all sites initially blocked.
     * @param  n the number of cols and rows
     * @throws IllegalArgumentException if {@code n <= 0}
     */
    public Percolation(int n){
        this.n = n;
        if(n <= 0){
            throw new IllegalArgumentException("n < 0");
        }else{
            int sitesCount = n * n;
            ufAct = new WeightedQuickUnionUF(sitesCount + 1);
            ufVir = new WeightedQuickUnionUF(sitesCount + 2);
            state = new boolean[sitesCount + 2];
            for(int i = 1; i < sitesCount + 1; i++){
                state[i] = false;
            }
            state[0] = true;
            state[sitesCount + 1] = true;
        }
    }

    /**
     * Opens the site (row, col) if it is not open already.
     * @param  row one element
     * @param  col th other element
     * @throws IllegalArgumentException unless {@code row < 1 || row > n || col < 1 || col > n}
     */
    public void open(int row, int col){
        if(row < 1 || row > n || col < 1 || col > n){
            throw new IllegalArgumentException("out of bound");
        }
        int cur = (row - 1) * n + col;
        state[cur] = true;
        if (col != 1 && isOpen(row, col - 1)) {
            ufAct.union(cur, cur - 1);
            ufVir.union(cur, cur - 1);
        }
        if (col != n && isOpen(row, col + 1)) {
            ufAct.union(cur, cur + 1);
            ufVir.union(cur, cur + 1);
        }
        if (row != 1 && isOpen(row - 1, col)) {
            ufAct.union(cur, cur - n);
            ufVir.union(cur, cur - n);
        }
        if (row != n && isOpen(row + 1, col)) {
            ufAct.union(cur, cur + n);
            ufVir.union(cur, cur + n);
        }
        if(row == 1){
            ufAct.union(0, cur);
            ufVir.union(0,cur);
        }else if(row == n){
            ufVir.union(cur, n * n + 1);
        }
        openSitesCount++;
    }

    /**
     * Is the site (row, col) open?
     * @param  row one element
     * @param  col th other element
     * @return {@code true} if {@code state[(row - 1) * n + col]} is true;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless {@code row < 1 || row > n || col < 1 || col > n}
     */
    public boolean isOpen(int row, int col){
        if(row < 1 || row > n || col < 1 || col > n){
            throw new IllegalArgumentException("out of bound");
        }
        return state[(row - 1) * n + col];
    }

    /**
     * Is the site (row, col) full?
     * @param  row one element
     * @param  col th other element
     * @return {@code true} if the site {@code 0} and {@code (row - 1) * n + col} are connected;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless {@code row < 1 || row > n || col < 1 || col > n}
     */
    public boolean isFull(int row, int col){
        if(row < 1 || row > n || col < 1 || col > n){
            throw new IllegalArgumentException("out of bound");
        }
        return ufAct.find(0) == ufAct.find((row - 1) * n + col);
    }

    /**
     * Returns the number of open sites
     * @return {@code openSitesCount}
     */
    public int numberOfOpenSites(){
        return openSitesCount;
    }

    /**
     * Does the system percolate?
     * @return {@code true} if the site {@code 0} and {@code n * n + 1} are connected;
     *         {@code false} otherwise
     */
    public boolean percolates(){
        return ufVir.find(0) == ufVir.find(n * n + 1);
    }
}