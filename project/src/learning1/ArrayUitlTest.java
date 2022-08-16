package learning1;

public class ArrayUitlTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 0;i < arr.length;i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.print(arr);
        arrayUtil.printStart();
        arrayUtil.getMin(arr);
        arrayUtil.printStart();
        arrayUtil.getMax(arr);
        arrayUtil.printStart();
        arrayUtil.getSum(arr);
        arrayUtil.printStart();
        arrayUtil.getAvg(arr);
        arrayUtil.printStart();
        arrayUtil.sort(arr);
        arrayUtil.print(arr);
        arrayUtil.printStart();
        arrayUtil.reverse(arr);
        arrayUtil.print(arr);
        arrayUtil.getIndex(arr,13);
    }
}
