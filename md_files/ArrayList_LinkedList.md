# 每天一道面试题

# ArrayList和LinkedList的区别

　　LinkedeList和ArrayList都实现了List接口，但是它们的工作原理却不一样。它们之间最主要的区别在于ArrayList是可改变大小的数组，而LinkedList是双向链接串列(doubly LinkedList)。ArrayList更受欢迎，很多场景下ArrayList比LinkedList更为适用。

1. ArrayList底层是通过数组实现的，随机访问数据的时间复杂度是O(1)，但是插入或者删除数据的开销是很大的，因为这需要重排数组中的所有数据。
2. LinkedList使用了循环双向链表的数据结构。所以，LinkedList的插入和删除操作的时间复杂度是O(1)。LinkedList不支持高效的随机元素访问，其随机访问的时间复杂度是O(n)。另外，LinkedList需要更多地内存，因为ArrayList的每个索引的位置是实际的数据，而LinkedList中每个节点中存储的是实际的数据和前后节点的位置。
3. ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间。

## 适用场景
1. 如果你的应用经常需要随机访问数据，则选择ArrayList。
2. 如果你的应用更多的是插入和删除元素，更少的读取数据，则应该选择LinkedList。

## Tips
1. ArrayList和LinkedList都是线程不安全的，所以涉及到多线程访问的时候，需要做同步处理。
2. 使用ArrayList的时候，记得给定一个合适的初始大小，尽可能的减少更改数组的大小。

