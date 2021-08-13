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
&nbsp;

# Week 1
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

