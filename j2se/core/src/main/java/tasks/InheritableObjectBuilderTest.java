package tasks;

class InheritableObjectBuilderTest {
    static class A implements Cloneable {
        private String aF;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public void setAF(String f) {
            this.aF = f;
        }

        public static ABuilder<? extends ABuilder> newBuilder() {
            return new A().new ABuilder();
        }

        @Override
        public String toString() {
            return "A{" +
                    "aF='" + aF + '\'' +
                    "}\n*****\n";
        }

        class ABuilder<T extends ABuilder> {
            public T setAF(String f) {
                A.this.setAF(f);
                return (T) this;
            }

            public A build() throws CloneNotSupportedException {
                return (A) A.this.clone();
            }
        }
    }

    static class B extends A {
        private String bF;

        public void setBF(String f) {
            this.bF = f;
        }

        @Override
        public String toString() {
            return "B{" +
                    "bF='" + bF + '\'' +
                    "}\n" + super.toString();
        }

        class BBuilder<T extends BBuilder> extends ABuilder<T> {
            public T setBF(String f) {
                B.this.setBF(f);
                return (T) this;
            }

            @Override
            public B build() throws CloneNotSupportedException {
                return (B) B.this.clone();
            }
        }

        public static BBuilder<? extends BBuilder<? extends BBuilder>> newBuilder() {
            return new B().new BBuilder<>();
        }
    }

    static class C extends B {
        private String cF;

        public void setCF(String f) {
            this.cF = f;
        }

        @Override
        public String toString() {
            return "C{" +
                    "cF='" + cF + '\'' +
                    "}\n" + super.toString();
        }

        class CBuilder<T extends CBuilder> extends BBuilder<T> {
            public T setCF(String f) {
                C.this.setCF(f);
                return (T) this;
            }

            @Override
            public C build() throws CloneNotSupportedException {
                return (C) C.this.clone();
            }
        }

        public static CBuilder<? extends CBuilder<? extends CBuilder>> newBuilder() {
            return new C().new CBuilder<>();
        }
    }

    static class D extends C {
        private String dF;

        public void setDF(String f) {
            this.dF = f;
        }

        @Override
        public String toString() {
            return "D{" +
                    "dF='" + dF + '\'' +
                    "}\n" + super.toString();
        }

        class DBuilder<T extends DBuilder> extends CBuilder<T> {
            public T setDF(String f) {
                D.this.setDF(f);
                return (T) this;
            }

            @Override
            public D build() throws CloneNotSupportedException {
                return (D) D.this.clone();
            }
        }

        public static DBuilder<? extends DBuilder<? extends DBuilder<? extends DBuilder>>> newBuilder() {
            return new D().new DBuilder<>();
        }
    }

    public static void main(String... args) throws CloneNotSupportedException {
        A a = A.newBuilder().setAF("af").build();
        B b = B.newBuilder().setAF("af").setBF("bf").build();
        C c = C.newBuilder().setAF("af").setBF("bf").setCF("cf").build();
        D.DBuilder<? extends D.DBuilder<? extends D.DBuilder<? extends D.DBuilder>>> db = D.newBuilder();
        D d = db.setAF("af").setBF("bf").setCF("cf").setDF("df").build();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        D d1 = db.setDF("df2").build();
        System.out.println(d);
        System.out.println(d1);
        System.out.println(d1 == d);
    }
}
