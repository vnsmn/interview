# Serialization #

***
<a name="a1"></a>
`1` *Given*

```java
public class SampleSerialization {
    static class A {
        private int f1 = 100;

        public A() {
            System.out.println("A.f1=" + f1);
        }
    }

    static class B extends A implements Serializable {
        private int f2 = 100;

        public B() {
            System.out.println("B.f2=" + f2);
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
 * A.f1=100
 * B.f2=100
 * serialization
 * A.f1=100
```
>2. 
```java 
 * A.f1=100
 * B.f2=100
 * serialization
 * A.f1=100
 * B.f1=100
```
>3.
```java 
 * A.f1=100
 * B.f2=100
 * serialization
```

<details>
  <summary><strong title="1">![][key]</strong></summary>
    1 are correct.</br>
    <a href="SampleSerialization.java" title="code">![][code]</a>
</details>

######*see*: [Serializable](http://docs.oracle.com/javase/7/docs/api/index.html?java/io/Serializable.html)
***

[key]: https://github.com/vnsmn/interview/blob/master/images/key.png
[help]: https://github.com/vnsmn/interview/blob/master/images/question-24.png
[code]: https://github.com/vnsmn/interview/blob/master/images/source-code-24.png
