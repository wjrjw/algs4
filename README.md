:tada: my Solutions for Princeton [`Algorithms Part I`](https://www.coursera.org/learn/algorithms-part1/home/welcome) , [`Part II`](https://www.coursera.org/learn/algorithms-part2/home/welcome) on Coursera

&nbsp;

[`Algorithms, 4th Edition`](https://algs4.cs.princeton.edu/home/)


[`algs4-data`](https://algs4.cs.princeton.edu/code/algs4-data.zip): all Data Files used in the Textbook.

[`my NOTEs`](https://github.com/tiiaan/ddup/blob/master/notes/%E7%AE%97%E6%B3%95/%E5%9F%BA%E7%A1%80%E7%AE%97%E6%B3%95.md)


&nbsp;
&nbsp;

# 环境配置
`win10`   `IDEA`

- 将 algs.jar 导入IDEA：File - Project Structure - Modules - Add - Apply -OK
- 运行测试程序

`/hello/src/test.java`

```java
import edu.princeton.cs.algs4.CollisionSystem;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;

public class test {
    public static void main(String[] args) {
        int n = 50;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }
        StdDraw.enableDoubleBuffering();
        Particle[] particles = new Particle[n];
        for (int i = 0; i < n; i++) {
            particles[i] = new Particle();
        }
        CollisionSystem system = new CollisionSystem(particles);
        system.simulate(Double.POSITIVE_INFINITY);
    }
}
```

&nbsp;

`/hello/src/HelloWorld.java`

```java
public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello, World");
    }
}
```


&nbsp;


`/hello/src/HelloGoodbye.java`
```java
public class HelloGoodbye {
    public static void main(String[] args){
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
```

&nbsp;

`/hello/src/RandomWord.java`

```java
```


&nbsp;
&nbsp;

# Assignment 1: Percolation

[`Percolation`](https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php)

## Model

<div align=center>
	<img src="https://gitee.com/tiiaan/repo/raw/master/img/202108161611279.png" width="500">
</div>

<div align=center>
	<img src="https://gitee.com/tiiaan/repo/raw/master/img/202108161611912.png" width="700">
</div>


## Task

## Solution
```java
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){

    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col){

    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){

    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){

    }
    // returns the number of open sites
    public int numberOfOpenSites(){

    }
    // does the system percolate?
    public boolean percolates(){

    }
    // test client (optional)
    public static void main(String[] args){

    }
}
```

```java
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {
    public PercolationStats(int n, int trials){

    }
    public double mean(){

    }
    public double stddev(){

    }
    public double confidenceLo(){

    }
    public double confidenceHi(){

    }
    public static void main(String[] args){

    }
}
```
