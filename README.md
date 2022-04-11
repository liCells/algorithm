# 算法学习

## 感悟

- 做一道题前需要认真理解题意, 可以花费较长时间认真理解, 需要有耐心;
- 对边界值处理要结合题意仔细考虑到所有情况;
- 可以根据具体的数据结构及参数猜测大概解题方向;
- 代码编写完成后, 考虑注释及代码优化;
- 答题错误后, 从头认真梳理细节;
- 答题完成后, 考虑更优解;
- 可以抽时间认真回顾以往题目;
- 如果遇到看不懂的,没有思路的, 先跳过, 学习基础知识再看;

> 注意分解问题， 类似于`572 另一棵树的子树`问题， 可以向下分解为遍历和相同的树， 
> 相同的树可以参考`100 相同的树`

> 注意题中的一些重复判断, 尽量移除掉

### 摸索

1. 先理解题意
2. 分解问题，获取到最终子问题
3. 考虑边界

- 在优化时考虑重复的子问题,尽量多的避免重复计算
- 在优化时考虑存储的数据是否所有都是必须的,参考`斐波那契数`

### 递归与动态规划

递归是自顶而下的形式,而动态规划则是相反,自底而上
