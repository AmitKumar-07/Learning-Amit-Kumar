package systemDesign.lowLevelDesign.DesignPatterns.creational.Builder;


public class StudentBuilder {

    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public Student build() {
        //Add validation logic in the build() method of StudentBuilder to ensure all required fields are initialized properly
        if (name == null || fatherName == null) {
            throw new IllegalArgumentException("Name and FatherName are required fields");
        }

        return new Student(this);
    }
}
