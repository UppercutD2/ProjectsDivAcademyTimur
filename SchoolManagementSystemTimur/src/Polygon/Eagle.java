package Polygon;

public class Eagle extends Animals{
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String toString()
    {
        return "This is Eagle to String";
    }
}
