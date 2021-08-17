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
    public int count(){
        return count;
    }
}
