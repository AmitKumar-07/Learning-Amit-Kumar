package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

public interface EmployeeDao {

    void create(Employee employee) throws Exception;
    void delete(Employee employee) throws Exception;
    Employee get(Employee employee) throws Exception;
}
