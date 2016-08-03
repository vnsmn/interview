# Serialization #

<a name="a1"></a>
`1` *Given*

```java
public class SampleSerialization {
    static class A {
        private int f11 = 11;

        public A() {
            System.out.println("A.f11=" + f11);
        }
    }

    static class B extends A implements Serializable {
        private int f21 = 21;

        public B() {
            System.out.println("B.f21=" + f21);
        }
    }

    public static void main(String... args) {
        B b = new B();

        System.out.println("serialization");

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(b);
            os.close();

            try {
                ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
                ObjectInputStream is = new ObjectInputStream(in);
                is.readObject();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

*Что распечает следующий код ?*
>1.
```java 
    A.f11=11
    B.f21=21
    serialization
    A.f11=11
```
>2. 
```java 
    A.f11=11
    B.f21=21
    serialization
    A.f11=11
    B.f21=21
```
>3.
```java 
    A.f1=100
    B.f2=100
    serialization
```

<details>
  <summary><strong title="1">![][key]</strong></summary>
    1 are correct.</br>
    <a href="SampleSerialization1.java" title="SampleSerialization1.java">![][code]</a>
</details>

######*see*: [Serializable](http://docs.oracle.com/javase/7/docs/api/index.html?java/io/Serializable.html)

***
<a name="a2"></a>
`2` *Given*

```java
public class SampleSerialization {
    static class A {
        transient protected int f11 = 11;

        public A() {
            System.out.println("A.f11=" + f11);
        }
    }

    static class B extends A implements Serializable {
        transient protected int f21 = 21;

        public B() {
            System.out.println("B.f21=" + f21);
        }
    }

    public static void main(String... args) {
        B b = new B();
        b.f11 = 110;
        b.f21 = 210;

        System.out.println("serialization");

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(b);
            os.close();

            try {
                ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
                ObjectInputStream is = new ObjectInputStream(in);
                b = (B) is.readObject();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("deserialization");

            System.out.println("B.f11=" + b.f11);
            System.out.println("B.f21=" + b.f21);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

*Что распечает следующий код ?*
>1.
```java 
    A.f11=11
    B.f21=21
    serialization
    A.f11=11
    deserialization
    B.f11=11
    B.f21=0
```
>2. 
```java 
    A.f11=11
    B.f21=21
    serialization
    A.f11=11
    deserialization
    B.f11=110
    B.f21=210
```
>3.
```java 
    A.f11=11
    B.f21=21
    serialization
    A.f11=11
    deserialization
    B.f11=0
    B.f21=0
```

<details>
  <summary><strong title="1">![][key]</strong></summary>
    1 are correct.</br>
    <a href="SampleSerialization2.java" title="SampleSerialization2.java">![][code]</a>
</details>

######*see*: [Serializable](http://docs.oracle.com/javase/7/docs/api/index.html?java/io/Serializable.html)
***

[key]: https://github.com/vnsmn/interview/blob/master/images/key.png
[help]: https://github.com/vnsmn/interview/blob/master/images/question-24.png
[code]: https://github.com/vnsmn/interview/blob/master/images/source-code-24.png
