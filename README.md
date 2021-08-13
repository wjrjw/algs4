:tada: my Solutions for Princeton [`Algorithms Part I`](https://www.coursera.org/learn/algorithms-part1/home/welcome) , [`Part II`](https://www.coursera.org/learn/algorithms-part2/home/welcome) on Coursera


&nbsp;
&nbsp;

# 环境配置
`win10`   `IDEA`

将algs.jar添加到IDEA项目：File - Project Structure - Modules - Add - Apply -OK

运行下面这段测试程序

`test.java`
```java
import edu.princeton.cs.algs4.CollisionSystem;
import edu.princeton.cs.algs4.Particle;
import edu.princeton.cs.algs4.StdDraw;

public class test {
    public static void main(String[] args) {
        int n = 20;  // number of particles (default 20)
        if (args.length == 1) {
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

&nbsp;
&nbsp;

# Week 1
`HelloWorld.java`
```java
public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello, World");
    }
}
```

&nbsp;


`HelloGoodbye.java`
```java
public class HelloGoodbye {
    public static void main(String[] args){
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
```

&nbsp;


`RandomWord.java`
```java
```

