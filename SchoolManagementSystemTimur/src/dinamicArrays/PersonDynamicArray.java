package dinamicArrays;

import config.Person;
import schools.ClassRoom;


public abstract class PersonDynamicArray {
    private Person[] persons = new Person[0];


    public PersonDynamicArray() {

    }


    public Person[] getArray()
    {
     return this.persons;
    }


    public void add(Person person) {
        Person[] newPersons = new Person[persons.length + 1];

        for (int i = 0; i < persons.length; i++) {

            newPersons[i] = persons[i];
        }

        newPersons[newPersons.length - 1] = person;


        persons = newPersons;

    }

    public Person get(int index) {
        if (index > persons.length || index < 0) {
            System.out.println("Wrong index!!!!");
            return null;
        } else {
            return persons[index - 1];
        }
    }
    public boolean contains(Person person)
    {
        for(int i=0;i< persons.length;i++)
        {
            if(persons[i].equals(person))
                return true;
        }


        return false;
    }


    public int size() {

        return persons.length;
    }
}
