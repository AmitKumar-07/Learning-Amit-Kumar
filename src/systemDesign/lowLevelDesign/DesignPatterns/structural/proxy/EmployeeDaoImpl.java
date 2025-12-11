package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(Employee employee) throws Exception{
        System.out.println("Row added");
    }

    @Override
    public void delete(Employee employee) throws Exception{
        System.out.println("Row deleted");
    }

    @Override
    public Employee get(Employee employee) throws Exception{
        System.out.println("Fetching entry from database");
        return new Employee();
    }
}
