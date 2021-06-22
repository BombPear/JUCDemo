package com.atguigu.test;

import com.atguigu.bean.Student;
import org.junit.Test;

/**
 * @author lbstart
 * @create 2021-06-16 20:17
 */
public class StudentTest {
    /*

    */
    @Test
    public void testStudent(){
        Student[] students = new Student[20];
        for (int i = 0; i < 20; i++) {
            Student s = new Student();
            s.setNumber(i+1);
            s.setScore((int)(Math.random() * 101));
            s.setState((int)(Math.random() * 6 + 1));
            students[i] = s;
        }
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].getScore() < students[j+1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j+1] = temp;
                }
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
