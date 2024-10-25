Create a class Employee with below attributes:

employeeId - int
employeeName - String
age - int
gender - char
salary - double

where employeeId is the unique identifier of the employee, employeeName is the name of the employee, age is the age of 
the employee, gender is the gender of the employee and salary is the salary of the employee.

The above attributes should be private, write getters, setters and parameterized constructor as required.

Create class Solution with main method.
Implement two static methods - getEmployeeWithSecondLowestSalary and countEmployeesBasedOnAge in Solution class.

getEmployeeWithSecondLowestSalary method:
This method will take an array of Employee objects as a parameter.
The method will return the Employee object with the second lowest salary in the array of Employee objects.
If there are less than two employees in the array, then the method should return null.

countEmployeesBasedOnAge method:
This method will take two input parameters - array of Employee objects and an integer parameter (for age).
The method will return the count of employees from the array of Employee objects whose age matches with the input 
parameter.
If no employee with the given age is present in the array of Employee objects, then the method should return 0.

Note :

Two employee objects can have the same salary.
All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getEmployeeWithSecondLowestSalary method - The main method should print the employeeId followed by # and employeeName
from the returned Employee object, if the returned value is not null.

If the returned value is null then it should print "Null".

For countEmployeesBasedOnAge method - The main method should print the count of employees as it is, if the returned value
is greater than 0, otherwise it should print "No employee found for the given age".

Before calling these static methods in main, use Scanner to read the number of objects and objects to read the values of 
Employee objects referring attributes in the above mentioned attribute sequence.

Consider below sample input and output:

Input:
-------------
4
101
John
30
M
10000.00
102
Samantha
25
F
15000.00
103
Alex
28
M
12000.00
104
Lisa
30
F
15000.00
30

Output:
----------------
103#Alex
2


import java.util.*;

class Employee {
    private int employeeId;
    private String employeeName;
    private int age;
    private char gender;
    private double salary;

    public Employee(int employeeId, String employeeName, int age, char gender, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Solution {
    public static Employee getEmployeeWithSecondLowestSalary(Employee[] employees) {
        if (employees.length < 2) {
            return null;
        }

        Arrays.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        
        double lowestSalary = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > lowestSalary) {
                return employee;
            }
        }
        
        return null;
    }

    public static int countEmployeesBasedOnAge(Employee[] employees, int age) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getAge() == age) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Employee[] employees = new Employee[n];
        
        for (int i = 0; i < n; i++) {
            int employeeId = sc.nextInt();
            String employeeName = sc.next();
            int age = sc.nextInt();
            char gender = sc.next().charAt(0);
            double salary = sc.nextDouble();
            employees[i] = new Employee(employeeId, employeeName, age, gender, salary);
        }

        int ageToCount = sc.nextInt();
        
        Employee secondLowestSalaryEmployee = getEmployeeWithSecondLowestSalary(employees);
        if (secondLowestSalaryEmployee != null) {
            System.out.println(secondLowestSalaryEmployee.getEmployeeId() + "#" + secondLowestSalaryEmployee.getEmployeeName());
        } else {
            System.out.println("Null");
        }

        int ageCount = countEmployeesBasedOnAge(employees, ageToCount);
        if (ageCount > 0) {
            System.out.println(ageCount);
        } else {
            System.out.println("No employee found for the given age");
        }
        
        sc.close();
    }
}



Execution Flow:
Reading the Number of Employees:

The first input value 4 is read, indicating there are 4 employees. This number is stored in n and used to create an array of Employee objects named employees.
Reading Employee Details:

For each employee, the following data is read in sequence:

Employee 1: employeeId = 101, employeeName = "John", age = 30, gender = 'M', salary = 10000.00.
Employee 2: employeeId = 102, employeeName = "Samantha", age = 25, gender = 'F', salary = 15000.00.
Employee 3: employeeId = 103, employeeName = "Alex", age = 28, gender = 'M', salary = 12000.00.
Employee 4: employeeId = 104, employeeName = "Lisa", age = 30, gender = 'F', salary = 15000.00.
Each set of details is used to create an Employee object, which is stored in the employees array.

Reading Age for Counting:

The last input value 30 is read and stored in ageToCount, representing the age for which we want to count the employees.
Finding Employee with the Second-Lowest Salary:

The getEmployeeWithSecondLowestSalary method is called with the employees array as the argument.

Inside this method:

employees is sorted by salary in ascending order using Arrays.sort with a custom comparator on the salary attribute. After sorting, the employees are ordered as follows by salary:
Employee 1 (John) with salary = 10000.00
Employee 3 (Alex) with salary = 12000.00
Employee 2 (Samantha) with salary = 15000.00
Employee 4 (Lisa) with salary = 15000.00
The lowest salary, 10000.00, is identified. A loop then checks for the first salary greater than 10000.00, which is 12000.00, belonging to Employee 3 (Alex).
Employee 3 (Alex) is returned as the employee with the second-lowest salary.
In the main method:

The result is printed as 103#Alex (employeeId and employeeName of Employee 3 (Alex)), as he has the second-lowest salary in the sorted list.
Counting Employees Based on Age:

The countEmployeesBasedOnAge method is called with the employees array and ageToCount (30) as arguments.

Inside this method:

A loop iterates over each Employee object in employees to check if the age matches 30.
Employee 1 (John) and Employee 4 (Lisa) both have age = 30, so the count is incremented twice.
The final count, 2, is returned to the main method.
In the main method:

Since the count is 2, it is printed as-is, yielding the output 2.
Final Output:
Based on the above steps, the final output for this input is:

bash
Copy code
103#Alex
2
Explanation of Output:
103#Alex:

This output corresponds to the employee with the second-lowest salary, which is Employee 3 (Alex) with a salary of 12000.00.
2:

This output represents the count of employees aged 30, which includes Employee 1 (John) and Employee 4 (Lisa).


