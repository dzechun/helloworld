import lombok.Data;

@Data
public class Man extends Person{
    public int height;

    public Man(){}

    public void printHelloMan(){
        System.out.println("hello man");
    }
}
