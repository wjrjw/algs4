import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[]
    private int n;
    private int openSitesCount;
    private WeightedQuickUnionUF ufAct;
    private WeightedQuickUnionUF ufVir;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if(n <= 0){
            throw new IllegalArgumentException();
        }
        ufAct = new WeightedQuickUnionUF(n * n + 1);
        ufVir = new WeightedQuickUnionUF(n * n + 2);

    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if(row < 1 || row > n || col < 1 || col > n){
            throw new IllegalArgumentException();
        }
        int cur = (row - 1) * n + col;
        if(isOpen(row, col - 1)){
            ufAct.union(cur, cur - 1);
            ufVir.union(cur, cur - 1);
        }
        if(isOpen(row, col + 1)){
            ufAct.union(cur, cur + 1);
            ufVir.union(cur, cur + 1);
        }
        if(isOpen(row - 1, col)){
            ufAct.union(cur, cur - n);
            ufVir.union(cur, cur - n);
        }
        if(isOpen(row + 1, col)){
            ufAct.union(cur, cur + n);
            ufVir.union(cur, cur + n);
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(row < 1 || row > n || col < 1 || col > n){
            throw new IllegalArgumentException();
        }
        return
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if(row < 1 || row > n || col < 1 || col > n){
            throw new IllegalArgumentException();
        }
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