:tada: base:   Princeton [`Algorithms Part I`](https://www.coursera.org/learn/algorithms-part1/home/welcome) , [`Part II`](https://www.coursera.org/learn/algorithms-part2/home/welcome) on Coursera

:rocket: finder:   [`Algorithms, 4th`](https://algs4.cs.princeton.edu/home/)   [`algs4-data`](https://algs4.cs.princeton.edu/code/algs4-data.zip)   [`my NOTEs`](https://github.com/tiiaan/algs4/blob/master/notebook/BasicAlgorithm.md)

![](https://img.shields.io/badge/license-CC%20BY--SA%204.0-blue)   ![](https://img.shields.io/github/stars/tiiaan/alzheimer?style=social)

&nbsp;
&nbsp;

### 环境配置

- 配置 Java 环境
- 将 algs.jar 放到 Java 安装路径 lib 文件夹，比如我的：C:\Program Files\Java\jdk-16.0.1\lib
- 将 algs4.jar 的绝对路径添加到系统变量 CLASSPATH
- IDEA中导入 algs4.jar 包：File - Project Structure - Modules - Add - Apply -OK
- 运行测试程序

`/algs4/demos/hello/src/test.java`
```java
import edu.princeton.cs.algs4.CollisionSystem;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;
public class test {
    public static void main(String[] args) {
        int n = 50;  // number of particles (default 20)
        if (args.length == 10) {
            n = Integer.parseInt(args[0]);
        }
        // enable double buffering to support animations
        StdDraw.enableDoubleBuffering();
        // create the n particles
        Particle[] particles = new Particle[n];
        for (int i = 0; i < n; i++) {
            particles[i] = new Particle();
        }
        // simulate the system
        CollisionSystem system = new CollisionSystem(particles);
        system.simulate(Double.POSITIVE_INFINITY);
    }
}
```

### 目录结构

```
/algs4
----/assignments/ : 课后题源码
----/demos/       : 练习源码，每个示例（譬如BinarySearch）在idea按单独项目管理
----/notebook/    : 笔记、课后题思路
----/algs4.jar    : 官方包
```

