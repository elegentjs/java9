package win.elegentjs.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * spring演示创建多线程
 */
@Service
public class DemoService {

    @Async
    public void a() {
        while (true) {
            System.out.println("a");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Async
    public void b() {
        while (true) {
            System.out.println("b");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
