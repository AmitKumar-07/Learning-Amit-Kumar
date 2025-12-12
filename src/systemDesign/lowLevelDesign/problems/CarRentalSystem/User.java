package systemDesign.lowLevelDesign.problems.CarRentalSystem;

public class User {

    private int userId;
    private String name;
    private String drivingLicenseNo;

    public User(int userId, String name, String drivingLicenseNo) {
        this.userId = userId;
        this.name = name;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
                '}';
    }
}
