[TOC]
&nbsp;

教材：[`Algorithms 4th`](https://algs4.cs.princeton.edu/home/)

资源：[`data`](https://algs4.cs.princeton.edu/code/algs4-data.zip) &nbsp; [`code`](https://algs4.cs.princeton.edu/code/)

课程：[`Algorithms, Part I`](https://www.coursera.org/learn/algorithms-part1/home/welcome) &nbsp; [`Algorithms, Part II`](https://www.coursera.org/learn/algorithms-part2/home/welcome)

工具：[`Visualgo`](https://visualgo.net/en)


&nbsp;
<div align=center>
	<img src="https://gitee.com/tiiaan/repo/raw/master/img/202108161610839.png" width="500">
</div>


&nbsp;
&nbsp;

> Algorithms and data structures go hand in hand. In this book we take the view that data structures exist as the byproducts or end products of algorithms and that we must therefore study them in order to understand the algorithms.
> 

&nbsp;

> The following themes are reinforced throughout the txt book:
> - Good algorithms can make the difference between being able to solve a practical problem and not being able to address it at all.
> - An efficient algorithm can be as simple to code as an inefficient one.
> - Understanding the performance characteristics of an implementation can be an interesting and satisfying intellectual challenge.
> - The scientific method is an important tool in helping us choose among different methods for solving the same problem.
> - An iterative refinement process can lead to increasingly efficient algorithms.

&nbsp;
&nbsp;
# 1 基础
## 1.1 数据抽象

> A data type is a set of values and a set of operations on those values.

&nbsp;
数据抽象封装和重用代码，使我们可以定义非原始数据类型，进而支持面向对象编程。

## 大O表示法
- 描述 `最坏情况`
- 基于 `数据量`，反应长期增长率，存在 `临界点`，通常用数据量 `无限大`时的情况来衡量是否高效
- f(x) = O(g(x)) 表示的含义是f(x)以g(x)为 `上界`
- 大O忽略常数，只保留最高阶，通俗点说可以取 `最高次数项`去掉系数

&nbsp;
&nbsp;

# 数据结构

&nbsp;
&nbsp;

# 排序
|排序算法|时间复杂度|最好情况|最坏情况|空间复杂度|
|:---|:---:|:---:|:---:|:---|
|冒泡排序| | | | |

## 冒泡排序
![](https://www.runoob.com/wp-content/uploads/2019/03/bubbleSort.gif)

## 选择排序
![](https://www.runoob.com/wp-content/uploads/2019/03/selectionSort.gif)
## 插入排序
![](https://www.runoob.com/wp-content/uploads/2019/03/insertionSort.gif)

## 希尔排序

## 快速排序



&nbsp;
&nbsp;

# 查找

&nbsp;
&nbsp;

# 图

&nbsp;
&nbsp;

# 字符串

&nbsp;
&nbsp;

# 动态规划

&nbsp;
&nbsp;

# 贪心

&nbsp;
&nbsp;

# 10 其他
## 10.1 Knuth Shuffle
[`Ref1`](https://www.cnblogs.com/zhanghongfeng/p/11216793.html)


```java
import java.util.Random;
 
public static final Random gen = new Random();
 
// version for array of ints
public static void shuffle (int[] array) {
    int n = array.length;
    while (n > 1) {
        int k = gen.nextInt(n--); //decrements after using the value
        int temp = array[n];
        array[n] = array[k];
        array[k] = temp;
    }
}
// version for array of references
public static void shuffle (Object[] array) {
    int n = array.length;
    while (n > 1) {
        int k = gen.nextInt(n--); //decrements after using the value
        Object temp = array[n];
        array[n] = array[k];
        array[k] = temp;
    }
}
```

## 10.2 Union-Find
 [`Ref1`](https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3.md) [`Ref2`](https://www.jianshu.com/p/b67668670bef) 


### 10.2.1 模型

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
应用场景：
- 编译器判断同一个变量的不同引用
- 社交网络中的朋友圈

建立以触点为索引的 id[] 数组来表示连通分量，该算法有三种实现。


### quick-find

- id[i] 是 i 所在分量
- 当且仅当 id[p] == id[q] 时，p 和 q 连通
- 在同一个连通分量中所有触点 id[] 的值必须`全部相同`
- 若要合并两个分量，必须将两个集合中所有触点所对应的 id[] 元素变为同一个值
- find() 访问数组一次，union()访问数组

```java
public class QuickFindUF {
    private int[] id;
    public QuickFindUF(int n){
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
}
```

### quick-union

- id[i] 是 i 所在分量的`父节点`，id[id[...id[i]...]] 是 i 的`根节点`
- `树`和`森林`
- 当且仅当`根节点`相同时，触点连通
- union 操作将 p 树的根节点指向 q

<div align=center>
	<img src="https://gitee.com/tiiaan/repo/raw/master/img/202108201439120.png" width="500">
</div>

```java
```


### weighted quick-union

```java
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class UF {
    private int count;
    private int[] parent;
    private int[] size;
    public UF(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; ++i){
            parent[i] = i;
            size[i] = 1;
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
            size[rootP] += size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
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
        return find(p) == find(q);
    }
    public int count(){
        return count;
    }
    public static void main(String[] args){
        int n = StdIn.readInt();
        UF uf = new UF(n);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)){
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + "" + q);
        }
        StdOut.println(uf.count() + "components");
    }
}
```