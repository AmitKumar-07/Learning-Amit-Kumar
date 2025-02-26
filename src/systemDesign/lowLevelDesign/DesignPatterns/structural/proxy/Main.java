package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {

        try{
            EmployeeDao sde = new EmployeeDaoProxy();
            sde.create("admin", new Employee());
            System.out.println("operation successfully");

            EmployeeDao sde2 = new EmployeeDaoProxy();
            sde2.create("Non-admin", new Employee());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
