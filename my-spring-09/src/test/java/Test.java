/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-06-08 22:00
 */
public class Test {

    @org.junit.Test
    public void test_111(){

        Curry kuli = new Curry("Kuli", 11);
        Curry o = adjustName(kuli);

        System.out.println(o.getName());;

        int a = 1;

        adjustNumber(a);

        System.out.println(a);


    }


    private Curry adjustName(final Curry curry){
        String a = "skkksldkd";
        curry.setName(a);
        return curry;
    }

    private int adjustNumber(int  a){
        a+=a;
        return a;
    }
}
