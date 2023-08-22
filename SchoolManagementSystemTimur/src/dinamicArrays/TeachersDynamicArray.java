package dinamicArrays;


import config.Person;
import employees.Teacher;
import students.Student;

public class TeachersDynamicArray extends PersonDynamicArray {
    private Teacher[] teachers = new Teacher[0];


    public TeachersDynamicArray() {

    }
    public Teacher[] getArray()
    {
        return this.teachers;
    }

    public void add(Teacher teacher) {
        Teacher[] newTeachers = new Teacher[teachers.length + 1];

        for (int i = 0; i < teachers.length; i++) {

            newTeachers[i] = teachers[i];
        }

        newTeachers[newTeachers.length - 1] = teacher;


        teachers = newTeachers;

    }
    public void remove(Teacher teacher)
    {
        if(teachers.length>0) {
            delete(teacher);
            Teacher[] newTeachers = new Teacher[teachers.length - 1];
            int j=0;
            for(int i=0;i<teachers.length;i++)
            {
                if(teachers[i]!=null)
                {
                    newTeachers[j]=teachers[i];
                    j++;
                }

            }
            teachers=newTeachers;

        }

    }//reorganize array with deleted teachers

    public void delete(Teacher teacher)
    {
        for(int i=0;i<teachers.length;i++){
            if(teachers[i].equals(teacher))
            {
                teachers[i]=null;
                break;
            }
        }

    }//delets teacher from array

    public Teacher get(int index) {
        if (index > teachers.length || index < 0) {
            System.out.println("Wrong index!!!!");
            return null;
        } else {
            return teachers[index - 1];
        }
    }
    public void teachersListDetails()
    {
        for(Teacher t :teachers)
        {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println(t);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        }
    }
}
