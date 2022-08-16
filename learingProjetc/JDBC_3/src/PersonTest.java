import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson(){
        Person person = new Man();
        person.printHello();
        person.getName();

        Man man = (Man) person;
        man.printHelloMan();
        man.getHeight();
    }

}
