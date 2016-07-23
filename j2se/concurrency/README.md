# Concurrency
<a href="#" name="test1"></a>
sssssssssssssssssss1

*1. The following block of code creates a CopyOnWriteArrayList, adds elements to it, and prints the contents:  
*

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

0. 6
0. 12
0. 4 2
0. 4 2 6
0. Compilation fails
0. An exception is thrown at runtime

[answer]( "3") [^1]

######see: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***

*2. Given:
*

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

1. 12
1. 10
1. 4 2 6
1. 4 6
1. Compilation fails
1. An exception is thrown at runtime

[answer]( "3") [^2]

######see: [CopyOnWriteArrayList](http://www.google.com/url?q=http%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Futil%2Fconcurrent%2FCopyOnWriteArrayList.html&sa=D&sntz=1&usg=AFrqEzcUe8jylq_8cFi8NuZamP2TVqL0-A)
***

[^1]: test1
[^2]: test2

*[Concurrency]: Concurrency with the java.util.concurrent Package


[answer][11]

[11]: (  "test1")
hbkhjbkjhbkjhb

<a href="https://github.com/vnsmn/interview/blob/master/j2se/concurrency/question.md#test1">sssssssssssssssssss2</a>
