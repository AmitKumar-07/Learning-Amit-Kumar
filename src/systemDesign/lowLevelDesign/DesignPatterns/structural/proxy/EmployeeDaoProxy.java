package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

import javax.xml.bind.ValidationException;

public class EmployeeDaoProxy implements EmployeeDao{

    private EmployeeDao employeeDao;
    private String role;

    public EmployeeDaoProxy(String role){
        employeeDao = new EmployeeDaoImpl();
        this.role = role;
    }
    @Override
    public void create(Employee employee) throws Exception{
        if(role.equalsIgnoreCase("admin")){
            employeeDao.create(employee);
            return;
        }
        throw new ValidationException("access denied");
    }

    @Override
    public void delete(Employee employee) throws Exception{
        if(role.equalsIgnoreCase("admin")){
            employeeDao.delete(employee);
            return;
        }
        throw new ValidationException("access denied");
    }

    @Override
    public Employee get(Employee employee) throws Exception{
        if(role.equalsIgnoreCase("admin")){
            return employeeDao.get(employee);
        }
        throw new ValidationException("access denied");
    }
}
