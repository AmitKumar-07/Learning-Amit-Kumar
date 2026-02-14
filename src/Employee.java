import java.util.Objects;

public class Employee {
    String name;
    String department;
    Integer salary;

    public Employee(String name, String department, Integer salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        Employee emp = (Employee) obj;
        return Objects.equals(emp.name, this.name) && Objects.equals(emp.department, this.department)
                && Objects.equals(emp.salary, this.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
