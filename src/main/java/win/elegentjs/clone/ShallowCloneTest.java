/**
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    :
 * 做成日期    : 2017/11/30
 */
package win.elegentjs.clone;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Liupj
 * @date 2017/11/30.
 */
public class ShallowCloneTest {
    public static void main(String[] args) {
        Student s1 = new Student();

        Student s2 = s1.clone();

        System.out.println(s1 == s2);
    }


}



class Student implements Cloneable, Serializable {
    private String id;

    private String name;

    private Date Birthday;


    @Override
    protected Student clone() {
        Student student = null;

        try {
            student = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return student;
    }
}

