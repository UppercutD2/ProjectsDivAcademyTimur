package schools;

import dinamicArrays.StudentsDynamicArray;
import employees.Teacher;
import students.Student;

public class ClassRoom {


   //students
  private static int number;
  private String classID;
  private Teacher teacher;

  private StudentsDynamicArray stdDynArray;
  private String className ;

  public ClassRoom()
  {
    generateClassID();
    stdDynArray=new StudentsDynamicArray();

  }
  public ClassRoom(String className)
  {
    generateClassID();
    this.className=className;
    stdDynArray=new StudentsDynamicArray();
  }
  public void addStudent(Student student){
      stdDynArray.add(student);
  }

  public void removeStudent(Student student)
  {
    stdDynArray.remove(student);
  }

  public static int getNumber() {
    number++;
    return number;
  }

  public  void generateClassID()
  {
    int id = getNumber();
    this.classID = "C-"+ id;
  }

  public String getClassID(){
    return this.classID;
  }

  public StudentsDynamicArray getStdDynArray() {
    return stdDynArray;
  }


  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
   this.teacher=teacher;
  }
  public void removeTeacher()
  {
    this.teacher=null;
  }


  public String getClassName() {
    return className;
  }
  public String getTeacherOfClass()
  {
    if(teacher!=null)
    {
      return teacher.toString();
    }
    else
    {
      return "No Teacher Assigned";
    }
  }

  public void setClassName(String className) {
    this.className = className;
  }

  @Override
  public String toString(){
    return "Class Room ID: "+ this.getClassID()
            +"\n Class Name: " + this.className +'\n';

  }






  public void toStringWithDetails() {
    System.out.println("ClassRoom Name: " + this.className +
            "\n====================\n"
            + "Teacher: "+ getTeacherOfClass()+
            "\n=====================\n"
            );

  }
}
