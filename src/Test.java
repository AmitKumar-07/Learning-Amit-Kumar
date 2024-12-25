public class Test {

    int id;
    static int cnt;

   public Test(int id){
        this.id=id;
    }

    public void display(){
        System.out.println("id: "+id +" cnt: "+cnt);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Test.cnt = cnt;
    }
}
