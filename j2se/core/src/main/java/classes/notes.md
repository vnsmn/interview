### [Classes](https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html "Java Language Specification. Chapter 8. Classes") ###
[:back:](readme.md#readme)

<a name="a1"></a>

`1` *Class Members*

>1. Members of a class that are declared private are not inherited by subclasses of that class.

>2. Only members of a class that are declared protected or public are inherited by subclasses declared in a package other than the one in which the class is declared.

>3. Constructors, static initializers, and instance initializers are not members and therefore are not inherited.

>4. If a field declaration hides the declaration of another field, the two fields need not have the same type.<a href="package1/Test1.java" title="Test1.java">![][code]</a>

>5. If two or more (distinct) field modifiers appear in a field declaration, it is customary, though not required, that they appear in the order consistent with that shown above in the production for FieldModifier.
    <br>FieldModifier: Annotation public protected private static final transient volatile


***


[key]: https://github.com/vnsmn/interview/blob/master/images/key.png
[help]: https://github.com/vnsmn/interview/blob/master/images/question-24.png
[code]: https://github.com/vnsmn/interview/blob/master/images/source-code-24.png
