import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
    private int[] id;
    private int count;
    public QuickUnionUF(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    private int root(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }
    public void union(int p, int q){
        int pRoot = root(p);
        int qRoot = root(q);
        id[pRoot] = qRoot;
        count--;
    }
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }
    public int count(){
        return count;
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(n);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)){
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + "components");
    }
}