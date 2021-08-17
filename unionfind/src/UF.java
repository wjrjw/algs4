import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int count;
    private int[] id;
    private int[] size;
    public UF(int n){
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
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
        int count;
    }
}
