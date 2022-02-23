package com.xiaoxing.springframwork02.test.xiao;

import com.xiaoxing.springframwork02.test.bean.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author HENG.XING@HAND-CHINA.COM 2022-02-22 16:38
 */
public class test111 {

    @Test
    public void test13444(){

        ArrayList<Student> students = new ArrayList<>();

        for (int i =0;i<=10;i++){
            Student student = new Student();
            student.setSex(false);
            student.setId(""+i);
            students.add(student);
        }
        String id = null;


    }

    @Test
    public void test1244(){
        String a = "29-";

        if (a.contains("-")){
//            String[] split = a.split("-");
//            System.out.println(split.length);
//            System.out.println(split[0]);
//            System.out.println(split[1]);
            int lastIndex = a.lastIndexOf("-");
            System.out.println(lastIndex);
            String substring = a.substring(a.lastIndexOf("-"));
            System.out.println(substring);
        }

    }
}
