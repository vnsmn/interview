package classes.package1;

class Test1 {
    static class Test11 {
        protected Integer f1 = 1;
        void print() {
            System.out.println(f1);
        }
    }
    static class Test12 extends Test11 {
        protected Integer f1 = 2;
        void print() {
            System.out.println(f1);
            super.print();
        }
    }

    public static void main(String[] args) {
        Test11 test11 = new Test12();
        test11.print();
    }
}
