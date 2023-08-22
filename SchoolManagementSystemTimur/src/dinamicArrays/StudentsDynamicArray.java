package dinamicArrays;

import config.Person;
import students.Student;

public class StudentsDynamicArray extends PersonDynamicArray {

    private Student[] students = new Student[0];


    public StudentsDynamicArray() {

    }
    public Student[] getArray()
    {
        return this.students;
    }
    public void add(Student client) {
        Student[] newStudents = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++) {

            newStudents[i] = students[i];
        }

        newStudents[newStudents.length - 1] = client;


        students = newStudents;

    }

    public void remove(Student student)
    {
        if(students.length>0) {
            delete(student);
            Student[] newStudents = new Student[students.length - 1];
            int j=0;
            for(int i=0;i<students.length;i++)
            {
                if(students[i]!=null)
                {
                newStudents[j]=students[i];
                j++;
                }

            }
            students=newStudents;

        }

    }//reorganize array with deleted students

    public void delete(Student student)
    {
        for(int i=0;i<students.length;i++){
            if(students[i].equals(student))
            {
                students[i]=null;
                break;
            }
        }

    }//delets student from array

    public Student get(int index) {
        if (index > students.length || index < 0) {
            System.out.println("Wrong index!!!!");
            return null;
        } else {
            return students[index - 1];
        }
    }

    public int size() {

        return students.length;
    }

    public void studentListDetails()
    {

        for(Student s :students)
        {
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^\n" +
                    s.toAdminString() +
                    "^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        }

    }


}
