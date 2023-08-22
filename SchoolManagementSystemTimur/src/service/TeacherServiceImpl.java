package service;

import config.GlobalDatas;
import employees.Teacher;
import schools.ClassRoom;
import service.interfaces.TeacherServiceInter;
import students.Student;

public class TeacherServiceImpl implements TeacherServiceInter {


  @Override
    public  void seeAllStudents(Teacher teacher)
    {
      for(ClassRoom cr:GlobalDatas.classRoomsDynamicArray.getArray())
      {
        if(teacher.equals(cr.getTeacher()))//Check if teacher assigned to this class
        {
          Student[] stdArray = cr.getStdDynArray().getArray();

          if(stdArray.length==0)//checks if there are any Student assigned to this class
          {
            System.out.println("Class "+ cr.toString() + "has no students");
          }
          else
          {
            System.out.println("Class : "+ cr.toString());
            for(Student s:stdArray)
            {
              System.out.println(s.toTeacherString());//Prints data without passwords
            }
          }
        }
      }


    }//Teacher method to see Students assigned to his classes

    @Override
    public void seeAllClasses(Teacher teacher)
    {
      for(ClassRoom cr:GlobalDatas.classRoomsDynamicArray.getArray())
      {
        if(teacher.equals(cr.getTeacher()))//Check if teacher assigned to this class
        {
          System.out.println("Class : " + cr.toString());



        }
      }

  }
}
