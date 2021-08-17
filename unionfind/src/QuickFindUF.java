import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
    private int count;
    private int[] id;
    public QuickFindUF(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    public int find(int p){
        return (id[p]);
    }
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if (pID == qID){
            return;
        }
        for (int i = 0; i < id.length; i++){
            if (id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
    }
    public boolean connected(int p, int q){
        return (find(p) == find(q));
    }
    public int count(){
        return count;
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
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