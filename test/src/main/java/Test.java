import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Cereated by keker on 2019/4/26 14:05
 */

public class Test{


    // 总的请求个数
    public static final int requestTotal = 100;

    // 同一时刻最大的并发线程的个数
    public static final int concurrentThreadNum = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        Semaphore semaphore = new Semaphore(concurrentThreadNum);
        for (int i = 0; i< requestTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    String result = testRequestUri();
                    System.out.println(result);
                    semaphore.release();
                } catch (Exception e) {
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static String testRequestUri() throws InterruptedException{
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhaoke");
        map.put("age",26);
        return MyHttpClientUtils.postHttp("http://localhost:8883/user/test", map, 5000, 5000);

    }

}
