import org.junit.Test;

public class ReflectionTest {
    @Test
    public void test1(){
        Comparable<Integer> com = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return 0;
            }
        };
    }
}
