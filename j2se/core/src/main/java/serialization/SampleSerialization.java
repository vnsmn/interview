package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * print:
 * A.f1=100
 * B.f2=100
 * serialization
 * A.f1=100
 */
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
