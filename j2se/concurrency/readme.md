# Concurrency

`1`. *The following block of code creates a CopyOnWriteArrayList, adds elements to it, and prints the contents:*

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

```text
1. 6
2. 12
3. 4 2
4. 4 2 6
5. Compilation fails
6. An exception is thrown at runtime
```

<details> 
  <summary>[answer]( "3")</summary>
   3
   [answer]( "3")
</details>

######see: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***

`2`. *Given:*

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

```text
1. 12
2. 10
3. 4 2 6
4. 4 6
5. Compilation fails
6. An exception is thrown at runtime
```

[answer]( "3") [^2]

######see: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***

<a href="https://github.com/vnsmn/interview/blob/master/j2se/concurrency/question.md#test1">sssssssssssssssssss2</a>
