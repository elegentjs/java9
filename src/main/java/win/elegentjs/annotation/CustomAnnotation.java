package win.elegentjs.annotation;

/**
 * 自定义注解
 */
public @interface CustomAnnotation {

    // 注解只有属性，没有方法，如果注解只有value属性时，不需要写属性名，即@CustomAnnotation("world")
    String value() default "hello";


}
