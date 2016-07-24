# Concurrency

<a name="a1"></a>
`1` *The following block of code creates a CopyOnWriteArrayList, adds elements to it, and prints the contents:*

```java
CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
cowList.add(4);
cowList.add(2);
Iterator<Integer> it = cowList.iterator();
cowList.add(6);
while (it.hasNext()) {
	System.out.print(it.next() + " ");
}
```
*What is the result?*


>1. 6
>2. 12
>3. 4 2
>4. 4 2 6
>5. Compilation fails
>6. An exception is thrown at runtime


<details> 
  <summary><strong title="3">![][key]</strong></summary>
   3<br/>
   <a href="answer.md#a1" title="detail">![][help]</a>   
</details>

######*see*: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***
<a name="a2"></a>
`2` *Given:*

```java
CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
cowList.add(4);
cowList.add(2);
cowList.add(6);
Iterator<Integer> it = cowList.iterator();
cowList.remove(2);
while(it.hasNext()) {
    System.out.print(it.next() + " ");
}
```

*Which shows the output that will be produced?*

>1. 12
>2. 10
>3. 4 2 6
>4. 4 6
>5. Compilation fails
>6. An exception is thrown at runtime

<details> 
  <summary><strong title="3">![][key]</strong></summary>
   3<br/>
   <a href="answer.md#a2" title="detail">![][help]</a>   
</details>

######*see*: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***
<a name="a3"></a>
`3` *Which methods from a CopyOnWriteArrayList will cause a new copy of the internal array to be created? (Choose all that apply.)*
>1. add
>2. get
>3. iterator
>4. remove

<details> 
  <summary><strong title="1,4">![][key]</strong></summary>
   1,4<br/>
   <a href="answer.md#a3" title="detail">![][help]</a>   
</details>

######*see*: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***
<a name="a4"></a>
`4` *Given:*

```java
CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
cowList.add(4);
cowList.add(2);
cowList.add(6);
Iterator<Integer> it = cowList.iterator();
while(it.hasNext()) {
    System.out.print(it.next() + " ");
    it.remove();
}
```

*Which shows the output that will be produced?*

>1. 4
>2. 4 2 6
>3. 2 6
>4. 2
>5. Compilation fails
>6. UnsupportedOperationException is thrown at runtime

<details> 
  <summary><strong title="6 (version 1.8)">![][key]</strong></summary>
   6 (version 1.8)<br/>
   <a href="answer.md#a4" title="detail">![][help]</a>
</details>

######*see*: [CopyOnWriteArrayList](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/CopyOnWriteArrayList.html#iterator())
***
<a name="a5"></a>
`5` *Given:*

```java
ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(10);
```

*Which operation(s) can block indefinitely? (Choose all that apply.)*

>1. abq.add(1);
>2. abq.offer(1);
>3. abq.put(1);
>4. abq.offer(1, 5, TimeUnit.SECONDS);

<details> 
  <summary><strong title="3">![][key]</strong></summary>
   3<br/>
   <a href="answer.md#a5" title="detail">![][help]</a>   
</details>

######*see*: [ArrayBlockingQueue](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ArrayBlockingQueue.html)
***
<a name="a6"></a>
`6` *Given:*

```java
ConcurrentMap<String,Integer> ages = new ConcurrentHashMap<>(); (2)
ages.put("John", 23);
```

*Which method(s) would delete John from the map only if his value was still equal to 23?*

>1. ages.delete("John", 23);
>2. ages.deleteIfEquals("John", 23);
>3. ages.remove("John", 23);
>4. ages.removeIfEquals("John", 23);

<details>
  <summary><strong title="3">![][key]</strong></summary>
   3<br/>
   <a href="answer.md#a6" title="detail">![][help]</a>
   <a href="src/main/java/concurrency/ConcurrentHashMapExample.java" title="code">![][code]</a>
</details>

######*see*: [ConcurrentHashMap](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentHashMap.html),[ConcurrentMap](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ConcurrentMap.html),

***
<a name="a7"></a>
`7` *Which method represents the best approach to generating a random number between one and ten if the method will be called concurrently and repeatedly by multiple threads?*

```java
1. public static int randomA() {
    Random r = new Random();
    return r.nextInt(10) + 1;
}
2. private static Random sr = new Random();
    public static int randomB() {
    return sr.nextInt(10) + 1;
}
3. public static int randomC() {
    int i = (int)(Math.random() * 10 + 1);
    return i;
}
4. public static int randomD() {
    ThreadLocalRandom lr = ThreadLocalRandom.current();
    return lr.nextInt(1, 11);
}
```

<details>
  <summary><strong title="4">![][key]</strong></summary>
   4<br/>
   <a href="answer.md#a7" title="detail">![][help]</a>
</details>
***
<a name="a8"></a>
`8` *Given:*

```java
AtomicInteger i = new AtomicInteger();
```

*Which atomically increment i by 9? (Choose all that apply.)*

>1. i.addAndGet(9);
>2. i.getAndAdd(9);
>3. i.set(i.get() + 9);
>4. i.atomicIncrement(9);
>5. i = i + 9;

<details> 
  <summary><strong title="1,2">![][key]</strong></summary>
   1 and 2 are correct. The addAndGet and getAndAdd both increment the value stored in an AtomicInteger.<br/>      
</details>

######*see*: [AtomicInteger](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/atomic/AtomicInteger.html)
***
<a name="a9"></a>
`9` *Given:*

```java
public class LeaderBoard {
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private List<Integer> highScores = new ArrayList<>();
    public void addScore(Integer score) {
        // position A
        lock.lock();
        try {
            if (highScores.size() < 10) {
                highScores.add(score);
            } else if (highScores.get(highScores.size() - 1) < score) {
                highScores.set(highScores.size() - 1, score);
            } else {
                return;
            }
            Collections.sort(highScores, Collections.reverseOrder());
        } finally {
            lock.unlock();
        }
    }
    public List<Integer> getHighScores() {
        // position B
        lock.lock();
        try {
            return Collections.unmodifiableList(highScores);
        } finally {
            lock.unlock();
        }
    }
}
```

*Which block(s) of code best match the behavior of the methods in the LeaderBoard class?
(Choose all that apply.)*

>1. Lock lock = rwl.reentrantLock(); // should be inserted at position A
>2. Lock lock = rwl.reentrantLcock(); // should be inserted at position B
>3. Lock lock = rwl.readLock(); // should be inserted at position A
>4. Lock lock = rwl.readLock(); // should be inserted at position B
>5. Lock lock = rwl.writeLock(); // should be inserted at position A
>6. Lock lock = rwl.writeLock(); // should be inserted at position B

<details> 
  <summary><strong title="*">![][key]</strong></summary>         
</details>

######*see*: [ReentrantReadWriteLock](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantReadWriteLock.html)
***

[key]: https://github.com/vnsmn/interview/blob/master/images/key.png
[help]: https://github.com/vnsmn/interview/blob/master/images/question-24.png
[code]: https://github.com/vnsmn/interview/blob/master/images/source-code-24.png
