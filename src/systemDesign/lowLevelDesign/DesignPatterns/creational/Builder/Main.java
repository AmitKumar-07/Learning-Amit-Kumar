package systemDesign.lowLevelDesign.DesignPatterns.creational.Builder;

public class Main {
    public static void main(String[] args) {

        StudentBuilder studentBuilder = new StudentBuilder() ;
        Student st1 = studentBuilder.setRollNumber(1425).setAge(23).setName("Ramesh").setFatherName("Suresh").build();
        Student st2 = studentBuilder.setRollNumber(7777).setAge(25).setName("Amit").setFatherName("Mohan").build();

        System.out.println(st1);
        System.out.println(st2);

    }
}