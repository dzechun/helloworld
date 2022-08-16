package learning1;

public class StudentTest1 {
    public static void main(String[] args) {
        //声明student数组
        Student[] s = new Student[20];
        for(int i = 0;i < s.length;i++){
            //给数组元素赋值
            s[i] = new Student();
            //给Student对象的属性赋值：
            s[i].number = i + 1;
            //年纪：[1,6]
            s[i].state = (int) (Math.random() * 6 + 1);
            s[i].score = (int)(Math.random()*100+1);
        }
        //遍历学生数组
//        for(int i = 0;i < s.length;i++){
////            System.out.println(s[i].number+","+s[i].state+","+s[i].score);
//            System.out.println(s[i].info());
//        }

        //打印出三年级的学生信息
        for(int i = 0;i < s.length;i++){
            if(s[i].state == 3){
                System.out.println("学号："+ s[i].number + "年级：" + s[i].state + "成绩：" + s[i].score);
            }
        }

        //使用冒泡排序按学生成绩排序，并遍历所有学生信息
        for(int j = 0;j < s.length-1;j++){
            for(int i = 0;i < s.length -1 - j;i++){
                if(s[i].score > s[i+1].score){
                    int temp = s[i].score;
                    s[i].score = s[i+1].score;
                    s[i+1].score = temp;
                }
            }
        }
        for(int i = 0;i < s.length;i++){
            System.out.print(s[i].score + " ");
        }
    }

}
class Student{
    int number;//学号
    int state;//年级
    int score;//成绩

    //显示学生信息的方法
    public String info(){
        return "学号:" + number + "年级:" + state + "成绩:" + score;
    }
}