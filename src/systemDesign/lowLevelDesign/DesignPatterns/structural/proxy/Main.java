package systemDesign.lowLevelDesign.DesignPatterns.structural.proxy;

public class Main {
    public static void main(String[] args) {

        try{
            EmployeeDao sde1 = new EmployeeDaoProxy("admin");
            sde1.create(new Employee());
            System.out.println("operation successfully");

            EmployeeDao sde2 = new EmployeeDaoProxy("subuser");
            sde2.create(new Employee());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
