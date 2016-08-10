package names;

import java.awt.Point;

public class ObscuringTest {
    static Point Test = new Point(100, 200);

    public static void main(String s[]) {
        System.out.println(Test.x);
    }
}

class Test {
    static int x = 5;
}
