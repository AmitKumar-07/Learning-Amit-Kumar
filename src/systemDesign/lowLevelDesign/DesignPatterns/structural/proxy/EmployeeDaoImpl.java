package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, Employee employee) throws Exception{
        System.out.println("Row added for client: "+client);
    }

    @Override
    public void delete(String client, Employee employee) throws Exception{
        System.out.println("Row deleted for client: "+client);
    }

    @Override
    public Employee get(String client, Employee employee) throws Exception{
        System.out.println("Fetching entry from database for client: "+client);
        return new Employee();
    }
}
