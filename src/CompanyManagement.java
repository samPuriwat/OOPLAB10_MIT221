import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create interface instant
        employeeDAO dao = EmployeeDAOImpl.getInstance();

        //Get all Employee
        //displayAllEmployee(dao);
        //add new Employee
        //addNewEmployee(dao);
        //find Employee by ID
        //findEmployeeByID(dao);
        //update Employee by ID
        //updateEmployeeByID(dao);
        //delete Employee by ID
        //deleteEmployeeByID(dao);

        // Menu Options
        System.out.println("##### Welcome to Company Management System #####");
        int con = 1;

        do {
            menuOptionS(dao);
            System.out.print("Continue? (y/n): ");
            String s = sc.nextLine();
            con = s.equals("y") ? 1 : 0;
            if (con == 0) {
                System.out.println("Good Bye.");
                System.exit(1);
            }
        } while (con != 0);

    }//main

    private static void menuOptionS(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, select option below: ");
        int select = 1;
        do {
            System.out.println("1.Display all employee.");
            System.out.println("2.Add new employee.");
            System.out.println("3.Find employee by ID.");
            System.out.println("4.Update employee.");
            System.out.println("5.Delete employee.");
            System.out.println("6.Exit.");
            System.out.print("Select?: ");
            select = Integer.parseInt(sc.nextLine().trim());

            switch (select) {
                case 1:
                    displayAllEmployee(dao);
                    break;
                case 2:
                    addNewEmployee(dao);
                    break;
                case 3:
                    findEmployeeByID(dao);
                    break;
                case 4:
                    updateEmployeeByID(dao);
                    break;
                case 5:
                    deleteEmployeeByID(dao);
                    break;
                case 6:
                    System.out.println("Good Bye.");
                    System.exit(1);
                    break;
                default:
                    System.out.println("*** Please, select number 1-6 !!! ***");
                    System.out.println("#####################################");
            }
        } while (select < 1 || select > 6);
    }

    private static void deleteEmployeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Delete employee with ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deleteEmp(id);
    }

    private static void updateEmployeeByID(employeeDAO dao) {
        Employee emp = findEmployeeByID2(dao);
        Scanner sc = new Scanner(System.in);
        System.out.print("Update new salaray for employee ID "
                + emp.getEmpID() + ":");
        double ns = Double.parseDouble(sc.nextLine().trim());
        // update salary
        emp.setSalary(ns);
        dao.updateEmp(emp);
        System.out.println("Updated employee with ID: " + emp.getEmpID());
    }

    private static Employee findEmployeeByID2(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Update an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());

        return emp;
    }

    private static void findEmployeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());
    }

    private static void addNewEmployee(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter employee id: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter employee name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter employee position: ");
        String position = sc.nextLine().trim();
        System.out.print("Enter employee salary: ");
        double salary = Double.parseDouble(sc.nextLine().trim());
        //insert data to database
        Employee newEmp = new Employee(id, name, position, salary);
        dao.addEmp(newEmp);
        sc.close();

    }

    private static void displayAllEmployee(employeeDAO dao) {
        List<Employee> myEmp = dao.getAllEmp();
        for (Employee emp : myEmp) {
            System.out.println(emp.toString());
        }
    }
}//class
