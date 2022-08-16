package GenericsTest;

public class GenericsTest {

    //泛型方法printArray
    public static <E> void printArray(E[] inputArray){
        //输出数组元素
        for(E element : inputArray){
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //创建不同类型数组：Integer, Double和Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H','E','L','L','O'};

        System.out.println("int array");
        printArray(intArray);
        System.out.println("double array");
        printArray(doubleArray);

    }
}
