package serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * print:
 * A.f11=11
 * B.f21=21
 * serialization
 * A.f11=11
 */
public class SampleSerialization1 {
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
