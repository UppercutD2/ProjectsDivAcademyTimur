package dinamicArrays;

import employees.Teacher;
import schools.ClassRoom;
import students.Student;

public class ClassRoomDynamicArray {

    private ClassRoom[] classRooms = new ClassRoom[0];


    public ClassRoomDynamicArray() {


    }

    public ClassRoom[] getArray() {
        return this.classRooms;
    }

    public void add(ClassRoom classRoom) {
        ClassRoom[] newClassRooms = new ClassRoom[classRooms.length + 1];

        for (int i = 0; i < classRooms.length; i++) {

            newClassRooms[i] = classRooms[i];
        }

        newClassRooms[newClassRooms.length - 1] = classRoom;


        classRooms = newClassRooms;

    }

    public void remove(ClassRoom classRoom) {
        if (classRooms.length > 0) {
            delete(classRoom);
            ClassRoom[] newClassRooms = new ClassRoom[classRooms.length - 1];
            int j = 0;
            for (int i = 0; i < classRooms.length; i++) {
                if (classRooms[i] != null) {
                    newClassRooms[j] = classRooms[i];
                    j++;
                }

            }
            classRooms = newClassRooms;

        }

    }//reorganize array with deleted students

    public void delete(ClassRoom classRoom) {
        for (int i = 0; i < classRooms.length; i++) {
            if (classRooms[i].equals(classRoom)) {
                classRooms[i] = null;
                break;
            }
        }

    }//delets student from array


    public ClassRoom get(int index) {
        if (index > classRooms.length || index < 0) {
            System.out.println("Wrong index!!!!");
            return null;
        } else {
            return classRooms[index - 1];
        }
    }

    public int size() {

        return classRooms.length;
    }

    public ClassRoom getClassOfStudent(Student student)
    {ClassRoom classRoom = null;
        for(ClassRoom cr: classRooms)
        {
            StudentsDynamicArray array = cr.getStdDynArray();
            if(array.contains(student))
            {
                classRoom = cr;
                break;
            }
        }


        return classRoom;
    }


    public ClassRoom getClassOfTeacher(Teacher teacher)
    {
        ClassRoom classRoom = null;
        for(ClassRoom cr: classRooms)
        {
            Teacher teach = cr.getTeacher();
            if(teacher.equals(teach))
            {
                classRoom = cr;
                break;
            }
        }


        return classRoom;
    }



    public void removeStudentFromClass(Student student)
    {
        for (ClassRoom cr : classRooms)
        {
            StudentsDynamicArray  array = cr.getStdDynArray();
            if(array.contains(student))
            {
             array.remove(student);
            }
        }
    }

    public void classRoomListDetails() {

        for (ClassRoom s : classRooms) {
            if (s != null) {
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                        s.toString() +
                        "\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }
        }
    }
}




