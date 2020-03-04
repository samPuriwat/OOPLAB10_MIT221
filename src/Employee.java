public class Employee {
    //attributes
    private int empID;
    private String name;
    private String position;
    private double salary;
    //constructor

    public Employee(int empID, String name,
                    String position, double salary) {
        this.empID = empID;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    //getter and setter

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //toString


    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
