---
title: Union-Find并查集算法详解
date: 2021/8/22 14:29:30
summary: 
categories: Algorithm
tags:
  - UF
math: false
---

:tada: 我的算法学习仓库 [`git@github.com:tiiaan/algs4.git`](https://github.com/tiiaan/algs4)

&nbsp;

### 问题描述

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

### leetcode题解

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

