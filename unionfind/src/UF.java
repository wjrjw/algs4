public class UF {
    private int count;
    private final int[] parent;
    private final int[] size;
    public UF(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; ++i){
            parent[i] = i;
            size[i] = i;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if(size[rootP] > size[rootQ]){
            parent[rootQ] = rootP;
            size[rootP] = size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] = size[rootP];
        }
        count--;
    }
    public int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int count(){
        return count;
    }
}
