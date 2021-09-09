本文源码同步备份在我的算法学习仓库 [`tiiaan/algs4`](https://github.com/tiiaan/algs4)，另有解题仓库 [`tiiaan/leetcode`](https://github.com/tiiaan/leetcode)，欢迎 :star:

&nbsp;

讨论这个算法前先看一个例子，Coursera 上普林斯顿算法公开课  [`Algorithms Part I`](https://www.coursera.org/learn/algorithms-part1/home/welcome) 第一周的作业 [`percolation`](https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php) 渗滤问题

&nbsp;

### 问题描述


&nbsp;

### 模型定义

`动态连通性`（Dynamic Connectivity）问题的输入是整数对 (p, q) ，表示 p 和 q 相连通。

连通是一种等价关系，具有性质：

- 自反性，若 p 和 q 相连，则 p 和 p 相连、q 和 q 相连
- 对称性，若 p 和 q 相连，则 q 和 p 相连
- 传递性，若 p 和 q、 q 和 r 相连，则 p 和 r 相连

可以将相连的对象分到同一个`等价类`中。为方便描述，我们将对象称为`触点`，将整数对称为`连接`，将等价类称为`连通分量`。可以用集合的观点理解分量，如果 p、q 属于同一集合说明它们是相连的，如果不是只要把 p 所在的集合与 q 所在的集合归并就能建立连通关系。

为实现算法需要建立数据类型：

```java
public class UF{
	public UF(int N)   // 初始化 N 个触点
	public void union(int p, int q)   // 连通 p 和 q
	public int find(int p)   // 返回 p 所在分量的标识符
	public boolean connected(int p, int q)   // 判断 p 和 q 是否相连
	public int count()   // 分量数目
}
```

&nbsp;

### 解法思路

完整程序如下：
[`Percolation.java`](https://github.com/tiiaan/algs4/blob/87d21861ab1235c74d852ff32ffdcae6a0b5aeda/assignments/percolation/src/Percolation.java)


```java
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
```

`PercolationStats.java`
```java

```

Shell 运行可视化测试

```shell
java PercolationVisualizer backwash.txt
```

`PercolationVisualizer.java`
```java
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Font;
public class PercolationVisualizer {
    private static final int DELAY = 5;
    public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);
        int opened = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                }
                else{
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
            }
        }

        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25*N, -N*.025, opened + " open sites");
        if (perc.percolates()) {
            StdDraw.text(.75*N, -N*.025, "percolates");
        }
        else {
            StdDraw.text(.75*N, -N*.025, "does not percolate");
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        StdDraw.show();
        StdDraw.pause(0);
        StdDraw.enableDoubleBuffering();
        Percolation perc = new Percolation(N);
        draw(perc, N);
        StdDraw.show();
        StdDraw.pause(DELAY);
        StdDraw.enableDoubleBuffering();
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            StdDraw.show();
            StdDraw.pause(DELAY);
            StdDraw.enableDoubleBuffering();
        }
    }
}
```

<div align=center>
	<img src="https://gitee.com/tiiaan/repo/raw/master/img/202108251636701.png" width="300">
</div>

&nbsp;

### 并查集算法解析

&nbsp;

### leetcode相关题解

- [128. Longest Consecutive Sequence](https://leetcode-cn.com/problems/longest-consecutive-sequence/)

- [130. Surrounded Regions](https://leetcode-cn.com/problems/surrounded-regions/)

- [200. Number of Islands](https://leetcode-cn.com/problems/number-of-islands/)

- [399. Evaluate Division](https://leetcode-cn.com/problems/evaluate-division/)

- [547. Number of Provinces](https://leetcode-cn.com/problems/number-of-provinces/)

&nbsp;

### 小结



&nbsp;

### 参考阅读

- [Union-Find算法详解](https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3.md) @[github-labuladong / fucking-algorithm](https://github.com/labuladong/fucking-algorithm)

- [Union-Find algorithm-并查集算法](https://www.jianshu.com/p/b67668670bef) 

