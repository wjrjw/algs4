import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class QuickUnionUF {
    private int count;
    private final int[] id;
    public QuickUnionUF(int n){
        id = new int[n];
        count = n;
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    public int root(int x){
        while(id[x] != x){
            x = id[x];
        }
        return x;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
        count--;
    }
    public int count(){
        return count;
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}

/*
cd src
javac QuickUnionUF.java
java QuickUnionUF < tinyUF.txt
*/