package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.junit.Assert;

/**
 * <a href="https://github.com/vnsmn/interview/tree/master/j2se/concurrency/readme.md#a8">back</a>
 */
public class ConcurrentHashMapExample {
    static class ObjectTest {
        private int value;

        @Override
        public int hashCode() {
            return 7;
        }

        @Override
        public boolean equals(Object obj) {
            return ((ObjectTest) obj).value == value;
        }

        public ObjectTest(int value) {
            this.value = value;
        }
    }

    private void testPutMethod(Map<ObjectTest, ObjectTest> hashMap) throws InterruptedException {
        final CountDownLatch downLatch = new CountDownLatch(2);

        createThread(hashMap, downLatch, 1, 1000).start();
        createThread(hashMap, downLatch, 1001, 2000).start();

        downLatch.await();
    }

    private Thread createThread(Map<ObjectTest, ObjectTest> hashMap, CountDownLatch downLatch, int start, int end) {
        return new Thread(() -> {
            try {
                for (int i = start; i < end; i++) {
                    ObjectTest obj = new ObjectTest(i);
                    hashMap.put(obj, obj);
                    ObjectTest obj2 = hashMap.get(obj);
                    Assert.assertEquals(obj.value, obj2 == null ? 0 : obj2.value);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                downLatch.countDown();
            }
        });
    }

    public static void main(String... args) throws InterruptedException {
        ConcurrentHashMap<ObjectTest, ObjectTest> concurrentHashMap = new ConcurrentHashMap<>();
        HashMap<ObjectTest, ObjectTest> hashMap = new HashMap<>();
        System.out.print("\nstart method with HashMap\n");
        new ConcurrentHashMapExample().testPutMethod(hashMap);
        System.out.print("\nstart method with ConcurrentHashMap\n");
        new ConcurrentHashMapExample().testPutMethod(concurrentHashMap);
    }
}