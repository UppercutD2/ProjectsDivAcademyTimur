package service;

import service.interfaces.StudentServiceInter;
import students.Student;

public class StudentServiceImpl implements StudentServiceInter {


    @Override
    public void seeInfo(Student student) {
        System.out.println(student);
    }
}
