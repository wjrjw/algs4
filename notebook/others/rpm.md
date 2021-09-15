```
俄罗斯农夫乘法（Russian Peasant Multiplication,RPM）
计算两个大于1的整数M和N的积

Step01  将M和N分别写在A、B两列
Step02  Repeat
        (a) 将 A 的值乘以 2 得到新的值
        (b) 将 B 的值除以 2 并舍弃小数部分，得到新的值
        Until B = 1
Step03  将A列中对应的B列的值为偶数的数划掉
Step04  将A列中剩余的数求和并返回
```

