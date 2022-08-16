package learning20;
/*
*定义数组的工具类
 */
public class ArrayUtil {
    //求数组的最大值
    public static int getMax(int[] arr){
        int maxValue = arr[0];
        for(int i = 0;i < arr.length-1;i++){
            if(maxValue < arr[i+1]){
                maxValue = arr[i+1];
            }
        }
        return maxValue;
    }
    //求数组的最小值
    public static int getMin(int[] arr){
        int minValue = arr[0];
        for(int i = 0;i < arr.length - 1;i++){
            if(minValue > arr[i+1]){
                minValue = arr[i+1];
            }
        }
        return minValue;
    }
    //求数组的总和
    public static int getSum(int[] arr){
        int sumValue = 0;
        for(int i = 0;i < arr.length;i++){
            sumValue += arr[i];
        }
        return sumValue;
    }
    //求数组的平均值
    public static int getAvg(int[] arr){
        int avgValue = getSum(arr)/arr.length;
        return avgValue;
    }
    //反转数组
    public static void reverse(int[] arr){
        for(int i = 0;i < arr.length/2;i++){
            swap(arr,i,i+1);
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    //复制数组
    public static int[] copy(int[] arr){
        int[] arr1 = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }
    //数组排序
    public static void sort(int[] arr){
        //从小到大
        for(int i = 0;i < arr.length-1;i++){
            for(int j = 0;j < arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //遍历数组
    public static void print(int[] arr){
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    //查找指定元素
    public static int getIndex(int[] arr, int index){
        int startIndex = 0;
        int endIndex = arr.length-1;
        int foundIndex = 0;
        boolean isFlag = false;
        for(int i = startIndex;i <= endIndex;i++){
            int middleIndex =  (startIndex + endIndex)/2;
            if(index == arr[middleIndex]){
                foundIndex = middleIndex;
                isFlag = true;
                break;
            }else if(index < arr[middleIndex]){
                endIndex = middleIndex -1;
            }else if(index > arr[middleIndex]){
                startIndex = middleIndex + 1;
            }
        }
        if(!isFlag){
            System.out.println("Not found");
        }
        return foundIndex;
    }

    public static void printStart(){
        System.out.print("****************");
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
