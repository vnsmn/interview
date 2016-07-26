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
>2. Lock lock = rwl.reentrantLock(); // should be inserted at position B
>3. Lock lock = rwl.readLock(); // should be inserted at position A
>4. Lock lock = rwl.readLock(); // should be inserted at position B
>5. Lock lock = rwl.writeLock(); // should be inserted at position A
>6. Lock lock = rwl.writeLock(); // should be inserted at position B

<details>
  <summary><strong title="4,5">![][key]</strong></summary>
   4 and 5 are correct. The addScore method modifies the collection and, therefore, should
   use a write lock, while the getHighScores method only reads the collection and should use a
   read lock.
</details>

######*see*: [ReentrantReadWriteLock](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantReadWriteLock.html)
***
<a name="a10"></a>
`10` *Given:*

```java
ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
rwl.readLock().unlock();
System.out.println("READ-UNLOCK-1");
rwl.readLock().lock();
System.out.println("READ-LOCK-1");
rwl.readLock().lock();
System.out.println("READ-LOCK-2");
rwl.readLock().unlock();
System.out.println("READ-UNLOCK-2");
rwl.writeLock().lock();
System.out.println("WRITE-LOCK-1");
rwl.writeLock().unlock();
System.out.println("WRITE-UNLOCK-1");
```

*What is the result?*

>1. The code will not compile
>2. The code will compile and output:<br/>
> READ-UNLOCK-1<br/>
> READ-LOCK-1<br/>
> READ-LOCK-2<br/>
> READ-UNLOCK-2<br/>
>3. The code will compile and output:<br/>
> READ-UNLOCK-1<br/>
> READ-LOCK-1<br/>
> READ-LOCK-2<br/>
> READ-UNLOCK-2<br/>
> WRITE-LOCK-1<br/>
> WRITE-UNLOCK-1<br/>
>4. A java.lang.IllegalMonitorStateException will be thrown

<details>
  <summary><strong title="4">![][key]</strong></summary>
     4 is correct. A lock counts the number of times it has been locked. Calling lock
     increments the count, and calling unlock decrements the count. If a call to unlock decreases
     the count below zero, an exception is thrown.
</details>

######*see*: [ReentrantReadWriteLock](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReentrantReadWriteLock.html)
***
<a name="a11"></a>
`11` *Which class contains factory methods to produce preconfigured ExecutorService instances?*

>1. Executor
>2. Executors
>3. ExecutorService
>4. ExecutorServiceFactory

<details>
  <summary><strong title="2">![][key]</strong></summary>
     2 is correct. Executor is the super-interface for ExecutorService. You use Executors to
     easily obtain ExecutorService instances with predefined threading behavior. If the Executor
     interface does not produce ExecutorService instances with the behaviors that you desire,
     you can always look into using java.util.concurrent.AbstractExecutorService or
     java.util.concurrent.ThreadPoolExecutor directly.
</details>

######*see*: [Executors](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html)
***
<a name="a12"></a>
`12` *Given:*

```java
private Integer executeTask(ExecutorService service, Callable<Integer> task) {
// insert here
}
```
*Which set(s) of lines, when inserted, would correctly use the ExecutorService argument to execute the Callable and return the Callable 's result? (Choose all that apply.)*
>1.
```java
try {
    return service.submit(task);
} catch (Exception e) {
    return null;
}
```
>2.
```java
try {
    return service.execute(task);
} catch (Exception e) {
    return null;
}
```
>3.
```java
try {
    Future<Integer> future = service.submit(task);
    return future.get();
} catch (Exception e) {
    return null;
}
```
>4.
```java
try {
    Result<Integer> result = service.submit(task);
    return result.get();
} catch (Exception e) {
    return null;
}
```

<details>
  <summary><strong title="3">![][key]</strong></summary>
       3 is correct. When you submit a Callable to an ExecutorService for execution, you
       will receive a Future as the result. You can use the Future to check on the status of the
       Callable's execution, or just use the get method to block until the result is available.
</details>

######*see*: [ExecutorService](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html)
***
<a name="a13"></a>
`13` *Which are true? (Choose all that apply.)*

>1. A Runnable may return a result, but must not throw an Exception
>2. A Runnable must not return a result nor throw an Exception
>3. A Runnable must not return a result, but may throw an Exception
>4. A Runnable may return a result and throw an Exception
>5. A Callable may return a result, but must not throw an Exception
>6. A Callable must not return a result nor throw an Exception
>7. A Callable must not return a result, but may throw an Exception
>8. A Callable may return a result and throw an Exception

<details>
  <summary><strong title="2,8">![][key]</strong></summary>
       2 and 8 are correct. Runnable and Callable serve similar purposes. Runnable has been
       available in Java since version 1. Callable was introduced in Java 5 and serves as a more
       flexible alternative to Runnable. A Callable allows a generic return type and permits thrown
       exceptions, while a Runnable does not.
</details>

######*see*: [Callable](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Callable.html)
***
<a name="a14"></a>
`14` *Given*

```java
public static class IncrementAction extends RecursiveAction {
    private final int threshold;
    private final int[] myArray;
    private int start;
    private int end;

    public IncrementAction(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < threshold) {
            for (int i = start; i <= end; i++) {
                myArray[i]++;
            }
        } else {
            int midway = (end - start) / 2 + start;
            IncrementAction a1 = new IncrementAction(myArray, start,
                    midway, threshold);
            IncrementAction a2 = new IncrementAction(myArray, midway + 1,
                    end, threshold);
            invokeAll(a1, a2);
        }
    }
}
```

*Which line(s), when inserted at the end of the compute method, would correctly take the place of separate calls to fork() and join() ? (Choose all that apply.)*

>1. compute();
>2. forkAndJoin(a1, a2);
>3. computeAll(a1, a2);
>4. invokeAll(a1, a2);

<details>
  <summary><strong title="4">![][key]</strong></summary>
       4 is correct. The invokeAll method is a var args method that will fork all Fork-Join tasks,
       except one that will be invoked directly.
       1, 2, and 3 are incorrect; they would not correctly complete the Fork-Join process.
</details>

######*see*: [RecursiveAction](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/RecursiveAction.html)
***
<a name="a15"></a>
`15` *When writing a RecursiveTask subclass, which are true? (Choose all that apply.)*

>1. fork() and join() should be called on the same task
>2. fork() and compute() should be called on the same task
>3. compute() and join() should be called on the same task
>4. compute() should be called before fork()
>5. fork() should be called before compute()
>6. join() should be called after fork() but before compute()

<details>
  <summary><strong title="1,5">![][key]</strong></summary>
    1 and 5 are correct. When creating multiple ForkJoinTask instances, all tasks except one
    should be forked first so that they can be picked up by other Fork-Join worker threads. The final
    task should then be executed within the same thread (typically by calling compute() ) before
    calling join on all the forked tasks to await their results. In many cases, calling the methods in
    the wrong order will not result in any compiler errors, so care must be taken to call the methods
    in the correct order.
</details>

######*see*: [RecursiveTask](http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/RecursiveTask.html)
***




[key]: https://github.com/vnsmn/interview/blob/master/images/key.png
[help]: https://github.com/vnsmn/interview/blob/master/images/question-24.png
[code]: https://github.com/vnsmn/interview/blob/master/images/source-code-24.png
