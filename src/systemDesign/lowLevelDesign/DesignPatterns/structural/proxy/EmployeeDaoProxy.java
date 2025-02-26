package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

import javax.xml.bind.ValidationException;

public class EmployeeDaoProxy implements EmployeeDao{

    private EmployeeDao employeeDao;

    public EmployeeDaoProxy(){
        employeeDao = new EmployeeDaoImpl();
    }
    @Override
    public void create(String client, Employee employee) throws Exception{
        if(client.equalsIgnoreCase("admin")){
            employeeDao.create(client, employee);
            return;
        }
        throw new ValidationException("access denied");
    }

    @Override
    public void delete(String client, Employee employee) throws Exception{
        if(client.equalsIgnoreCase("admin")){
            employeeDao.delete(client, employee);
            return;
        }
        throw new ValidationException("access denied");
    }

    @Override
    public Employee get(String client, Employee employee) throws Exception{
        if(client.equalsIgnoreCase("admin")){
            return employeeDao.get(client, employee);
        }
        throw new ValidationException("access denied");
    }
}
