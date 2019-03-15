package win.elegentjs.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface CustomAnnotation {

    // 注解只有属性，没有方法，如果注解只有value属性时，不需要写属性名，即@CustomAnnotation("world")
    String value() default "hello";


}

@CustomAnnotation("world")
class Main {
    public static void main(String[] args) {
        Class<Main> clazz = Main.class;


        if (clazz.isAnnotationPresent(CustomAnnotation.class)) {
            CustomAnnotation customAnnotation = clazz.getAnnotation(CustomAnnotation.class);
            System.out.println("当前类： " + Main.class + " 有CustomAnnotation注解。注解值为：" + customAnnotation.value());
        } else {
            System.out.println("当前类：" + Main.class + " 没有注解。");
        }

    }
}
