package learning1;

public class ArrayTest4 {

    public static void main(String[] args){
        String[] arr1 = new String[]{"jj","dd","mm","bb","gg","aa"};
//        //数组的复制
//        String[] arr1 = new String[arr.length];
//        for(int i = 0;i < arr.length;i++){
//            arr1[i] = arr[i];
//        }


        //数组的反转
        for(int i = 0;i < arr1.length/2;i++){
            String temp;
            temp = arr1[i];
            arr1[i] = arr1[arr1.length-i-1];
            arr1[arr1.length-i-1] = temp;
        }

        for(int i = 0;i < arr1.length;i++){
            System.out.println(arr1[i]+" ");
        }

//        //查找
//        //线性查找
//        String dest = "bb";
//        boolean isFlag = true;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (dest.equals(arr[i])) {
//                System.out.print(i + 1);
//                isFlag = false;
//                break;
//            }
//        }
//        if(isFlag == true){
//            System.out.println("Not found");
//        }
//
//        //二分法查找
//        //前提：所要查找的数组必须有序
//        int[] arr2 = new int[]{-98,-34,2,34,54,66,105,210,333};
//
//        int dest1 = 211;
//        int head = 0;//初始的首索引
//        int end =  arr2.length-1;//初始的末索引
//        boolean isFlag1 = true;
//
//        while(head <= end){
//            int middle = (head + end)/2;
//            if(dest1 == arr2[middle]){
//                System.out.println("is:" + middle);
//                isFlag1 = false;
//                break;
//            }else if(arr2[middle] > dest1){
//                end = middle - 1;
//            }else if(arr2[middle] < dest1){
//                head = middle + 1;
//            }
//        }
//        if(isFlag1){
//            System.out.print("Not found");
//        }

    }
}
