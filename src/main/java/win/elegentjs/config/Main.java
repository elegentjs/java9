package win.elegentjs.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        DemoService demoService = applicationContext.getBean(DemoService.class);

        demoService.a();
        demoService.b();
    }
}
