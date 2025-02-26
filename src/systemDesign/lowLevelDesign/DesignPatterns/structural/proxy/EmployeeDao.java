package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

public interface EmployeeDao {

    void create(String client, Employee employee) throws Exception;
    void delete(String client, Employee employee) throws Exception;
    Employee get(String client, Employee employee) throws Exception;
}
