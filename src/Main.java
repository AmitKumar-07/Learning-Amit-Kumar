public class Main {
    public static void main(String[] args) {


        Test test= new Test(1);
        System.out.println(test.getId());

        System.out.println(Test.getCnt());
        Test.setCnt(12);
        System.out.println(Test.getCnt());

        Test test1 = new Test(4);
        test1.display();
    }
}