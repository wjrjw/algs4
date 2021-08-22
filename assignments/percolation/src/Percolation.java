import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[]
    private int n;
    private int[][] grid;
    private int openSitesCount;
    private WeightedQuickUnionUF ufAct;
    private WeightedQuickUnionUF ufVir;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        ufAct = new WeightedQuickUnionUF(n);
        ufVir = new WeightedQuickUnionUF(n);

    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col){

    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        return
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        return ufVir.connected(int p, int q);
    }
    // returns the number of open sites
    public int numberOfOpenSites(){
        return openSitesCount;
    }
    // does the system percolate?
    public boolean percolates(){
        return ufVir.==
    }
    // test client (optional)
    public static void main(String[] args){

    }
}