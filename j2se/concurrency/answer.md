# Answer

`1`<a name="a1"></a>
######*see*: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a1)
***
`2`<a name="a2"></a>

######*see*: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a2)
***
`3`<a name="a3"></a>
The iterator will not reflect additions, removals, or changes to the list since the iterator was created.
######*see*: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a3)
***
`4`<a name="a4"></a>
The iterator does NOT support the remove method.
######*see*: [CopyOnWriteArrayList](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArrayList.html#iterator())
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a3)
***
`5`<a name="a5"></a>
The add method will throw an IllegalStateException if the queue is full.
The two offer methods will return false if the queue is full. Only the put method will block
until space becomes available.
######*see*: [ArrayBlockingQueue](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ArrayBlockingQueue.html)
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a5)
***
`6`<a name="a6"></a>
The methods for answers 1, 2, and 4 do not exist in a ConcurrentHashMap. A traditional
Map contains a single-argument remove method that removes an element based on its key. The
ConcurrentMap interface (which ConcurrentHashMap implements) added the two-argument
remove method, which takes a key and a value. An element will only be removed from the Map
if its value matches the second argument. A boolean is returned to indicate if the element was
removed.
######*see*: [ConcurrentHashMap](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html)
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a6)
*** 
`7`<a name="a7"></a>
The ThreadLocalRandom creates and retrieves Random instances that are
specific to a thread. You could achieve the same effect prior to Java 7 by using the java.lang
.ThreadLocal and java.util.Random classes, but it would require several lines of code. Math
.random is thread-safe, but uses a shared java.util.Random instance and can suffer from
contention problems.
######*see*: [ThreadLocalRandom](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ThreadLocalRandom.html)
[:back:](https://github.com/vnsmn/interview/blob/master/j2se/concurrency/readme.md#a7)
*** 