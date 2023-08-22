package service;

import Util.Util;
import config.GlobalDatas;
import config.Person;
import employees.Teacher;
import schools.ClassRoom;
import service.interfaces.AdminServiceInter;
import students.Student;
import Util.ClassRoomUtil;


import java.util.Scanner;

public class AdminServiceImpl implements AdminServiceInter {




    @Override
    public void addStudent(Scanner console)
    {

            System.out.println("====Adding Student section====");
                Student student = new Student();
                student.generateId();
                student.setName(Util.nameChecker(console));
                student.setSurname(Util.surnameChecker(console));
                student.setAge(Util.ageChecker(console));
                student.setEmail(Util.emailChecker(console));
                student.setPassword(Util.passwordChecker(console));
                student.generateUsername();
                GlobalDatas.studentsDynamicArray.add(student);
                System.out.println("New Student has been added");
                System.out.println(student);

    }//Adding student to database

    @Override
    public void addTeacher(Scanner console) {

            System.out.println("====Adding Teacher Section====");
            Teacher teacher = new Teacher();
            teacher.generateId();
            teacher.setName(Util.nameChecker(console));
            teacher.setSurname(Util.surnameChecker(console));
            teacher.setAge(Util.ageChecker(console));
            teacher.setEmail(Util.emailChecker(console));
            teacher.setPassword(Util.passwordChecker(console));
            teacher.generateUsername();
            teacher.setSalary(Double.parseDouble(Util.requiredString("Enter Teacher Salary: ", console)));
            GlobalDatas.teachersDynamicArray.add(teacher);
            System.out.println("New Teacher has been added");
            System.out.println(teacher);


    }//adding Teacher TO DATABASE

    @Override
    public void deleteStudent(Scanner console)
    {
        boolean found = false;
        Student[] array =GlobalDatas.studentsDynamicArray.getArray();
        System.out.println("==========Student Deletion Section==========");
        String input = Util.requiredString("Enter Student Username : ",console);

        for(Student s: array)
        {
            if(input.equalsIgnoreCase(s.getUsername())){
                GlobalDatas.studentsDynamicArray.remove(s);
                found=true;
                break;
            }

        }
        if(!found)
        {
            System.out.println("Student with username : \"" + input + "\" not found.");
        }else
        {
            System.out.println("Student with username: \"" + input+"\" has been deleted.");
        }


    }//need to check if it is working or not)

    @Override
    public void printStudentList() {
        GlobalDatas.studentsDynamicArray.studentListDetails();
    }

    @Override
    public void printTeacherList() {
        GlobalDatas.teachersDynamicArray.teachersListDetails();
    }

    @Override
    public void printAdminLit() {
        GlobalDatas.adminsDynamicArray.adminListDetails();
    }

    @Override
    public void deleteTeacher(Scanner console) {
        boolean found = true;
        Teacher[] array =(Teacher[]) GlobalDatas.teachersDynamicArray.getArray();
        System.out.println("==========Teacher Deletion Section==========");
        String input = Util.requiredString("Enter Teacher Username : ",console);

        for(Teacher t: array)
        {
            if(input.equalsIgnoreCase(t.getUsername())){
                GlobalDatas.teachersDynamicArray.remove(t);
                found=false;
                break;
            }

        }
        if(!found)
        {
            System.out.println("Teacher with username : \"" + input + "\" not found.");
        }else
        {
            System.out.println("Teacher with username: \"" + input+"\" has been deleted.");
        }
    }

    @Override
    public void updateStudent() {

    }//to be filled

    @Override
    public void updateTeacher() {

    }//to b filled

    @Override
    public void blockStudent(Scanner console) {
            Student student = getStudentById(console);
            if(student!=null)
            student.setBlocked(true);
    }

    @Override
    public void blockTeacher(Scanner console) {
            Teacher teacher = getTeacherById(console);
            if(teacher!=null)
            teacher.setBlocked(true);
    }

    @Override
    public void openBlock(Person person) {
            person.setBlocked(false);
        System.out.println(person);
    }

    @Override
    public void searchForStudent(Scanner console) {
        Student[] students = (Student[]) GlobalDatas.studentsDynamicArray.getArray();
        boolean found = true;
        int id = Util.requiredInt("Please enter ID to search Student: ",console);
        for(Student s: students)
        {
            if(id==s.getId()){
                found = false;
                System.out.println(s);
            }
        }

        if(found)
        {
            System.out.println("Student with ID: " + id + " not found.");
        }
    }//By ID

    @Override
    public void searchForTeacher(Scanner console) {

        Teacher[] teachers = (Teacher[]) GlobalDatas.teachersDynamicArray.getArray();
        boolean found = true;
        int id = Util.requiredInt("Please enter ID to search Teacher: ",console);
        for(Teacher t: teachers)
        {
            if(id==t.getId()){
                found = false;
                System.out.println(t);
            }
        }

        if(found)
        {
            System.out.println("Teacher with ID: " + id + " not found.");
        }
    }//Search Teacher by ID

    @Override
    public Student getStudentById(Scanner console) {
       return null;
    }//returns student if found

    @Override
    public Teacher getTeacherById(Scanner console) {
       return null;
    } //returns teacher if found
}
