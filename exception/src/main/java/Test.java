/**
 * Create by xuzhijun.online on 2019/9/6.
 */
public class Test {
    public static void main(String[] args) {
        Requires.requireTrue(true, "Queue is not empty.");
        new Test().test();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }


    public void test(){
        throw new NullPointerException("dd");
    }
}
