/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/11/30
 */
package win.elegentjs.clone;

import java.io.*;

/**
 * @author Liupj
 * @date 2017/11/30.
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        Student o1 = new Student();
        Student o2 = clone(o1);

        System.out.println(o1 == o2);
    }



    public static <T extends Serializable> T clone(T obj) {
        T target = null;

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream ops = new ObjectOutputStream(bos);
            ops.writeObject(obj);
            ops.close();


            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            target = (T) ois.readObject();

            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return target;
    }
}





