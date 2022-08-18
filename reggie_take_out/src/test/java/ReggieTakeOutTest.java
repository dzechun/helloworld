import org.junit.jupiter.api.Test;

public class ReggieTakeOutTest {

    @Test
    public void testReggieTakeOut(){
        String s1 = new String("abcdefg");
        String s2 = new String("bcd");
        /*System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);*/
//        s1.replace(s1,s2);
//        System.out.println(s1.replace(s1,s2));
//        System.out.println(s1);
        s1 = s1.substring(1,6);
        System.out.println(s1);
    }
}
