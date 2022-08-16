package GenericsTest;

public class Box<T> {

    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("php");

        System.out.printf("int:" + integerBox.get());
        System.out.printf("string:" + stringBox.get());
    }
}
