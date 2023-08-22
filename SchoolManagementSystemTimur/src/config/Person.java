package config;

public abstract class Person {

    protected  String name  ;
    protected  String surname ;
    protected int age;
    private String username;
    private String password;


    public Person ()
    {}
    public Person(String name,String surname,int age,String username, String password)
    {
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.username=username;
        this.password=password;
    }


    private boolean isBlocked;
    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }






}
