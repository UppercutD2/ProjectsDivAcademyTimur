package service.interfaces;

import config.Person;
import employees.Teacher;
import students.Student;

import java.util.Scanner;

public interface AdminServiceInter {

    void addStudent(Scanner console);//+
    void addTeacher(Scanner console);//+

    void deleteStudent(Scanner console);//+
    void printStudentList();//+
    void printTeacherList();//+
    void printAdminLit();//+
    void deleteTeacher(Scanner console);//+

    void updateStudent();
    void updateTeacher();

    void blockStudent(Scanner console);
    void blockTeacher(Scanner console);


    void openBlock(Person person);

    void searchForStudent(Scanner console);
    void searchForTeacher(Scanner console);

    Student getStudentById(Scanner console);//+
    Teacher getTeacherById(Scanner console);//+





}
