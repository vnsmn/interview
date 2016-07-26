package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Question14 {
    public static class IncrementAction extends RecursiveAction {
        private final int threshold;
        private final int[] myArray;
        private int start;
        private int end;

        public IncrementAction(int[] myArray, int start, int end, int threshold) {
            this.threshold = threshold;
            this.myArray = myArray;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < threshold) {
                for (int i = start; i <= end; i++) {
                    myArray[i]++;
                }
            } else {
                int midway = (end - start) / 2 + start;
                IncrementAction a1 = new IncrementAction(myArray, start,
                        midway, threshold);
                IncrementAction a2 = new IncrementAction(myArray, midway + 1,
                        end, threshold);
                invokeAll(a1, a2);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[10_000_000];
        ForkJoinPool fjPool = new ForkJoinPool();
        IncrementAction action = new IncrementAction(data, 0, data.length, 1000);
        fjPool.invoke(action);
    }

}
