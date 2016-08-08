### Names ###
* [Java Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-6.html "Chapter 6. Names")

<a name="a1"></a>
`1` *Specify a name and a identifier*

```java
class Test {
    public static void main(String[] args) {
        Class c = System.out.getClass();
        System.out.println(c.toString().length() +
        args[0].length() + args.length);
    }
}
```

>1. identificators: Test, main , and the first occurrences of args and c;</br>
    names: String, Class, System.out.getClass, System.out.println, 
        c.toString, args, args.length.

>2. names: Test, main , and the first occurrences of args and c;</br>
    identificators: String, Class, System.out.getClass, System.out.println, 
        c.toString, args, args.length.

<details>
  <summary><strong title="1">![][key]</strong></summary>
    1 are correct.</br>
    The identifiers Test , main , and the first occurrences of args and c are not names. Rather,
    they are identifiers used in declarations to specify the names of the declared entities. The
    names String , Class , System.out.getClass , System.out.println , c.toString ,
    args , and args.length appear in the example.</br>
    A name is used to refer to an entity declared in a program.
    There are two forms of names: simple names and qualified names.
    A simple name is a single identifier.
    A qualified name consists of a name, a " . " token, and an identifier.    
</details>

######*see*: [Names](https://docs.oracle.com/javase/specs/jls/se8/html/jls-6.html "6.2. Names and Identifiers")

***

[key]: https://github.com/vnsmn/interview/blob/master/images/key.png
[help]: https://github.com/vnsmn/interview/blob/master/images/question-24.png
[code]: https://github.com/vnsmn/interview/blob/master/images/source-code-24.png
