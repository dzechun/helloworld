package ui;

import learning8.bean.Customer;
import service.CustomerList;
import util.CMUUtility;

public class CustomerView {
    private CustomerList customerlist = new CustomerList(10);

    public CustomerView(){
        Customer cust = new Customer("张三",'男',30,"010-56253825","abc@email.com");
        customerlist.addCustomer(cust);
    }

    /**
     * 显示客户信息管理软件界面的方法
     */
    private void enterMainMenu(){

        boolean isFlag = true;
        while (isFlag){
            System.out.println("\n-------------------客户信息管理系统-----------------");
            System.out.println("                     1.添加客户信息");
            System.out.println("                     2.修改客户信息");
            System.out.println("                     3.删除客户信息");
            System.out.println("                     4.显示客户信息");
            System.out.println("                     5.退       出\n");
            System.out.println("                     请选择(1-5):");

            char menu = CMUUtility.readMenuSelection();
            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)");
                    char isExit = CMUUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                        break;
                    }

            }
        }

    }

    /**
     * 添加客户的操作
     */
    private void addNewCustomer(){

        System.out.println("------------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUUtility.readChar();
        System.out.print("年龄：");
        int age = CMUUtility.readInt();
        System.out.print("电话：");
        String phone = CMUUtility.readString(13);
        System.out.print("邮箱:");
        String email = CMUUtility.readString(30);

        //将上述数据封装到对象中
        Customer customer = new Customer(name,gender,age,phone,email);

        boolean isSuccess = customerlist.addCustomer(customer);
        if(isSuccess){
            System.out.println("------------------------添加完成---------------------");
        }else{
            System.out.println("---------------------客户已满添加失败------------------");
        }

    }

    /**
     * 修改客户的操作
     */
    private void modifyCustomer(){
//        System.out.println("修改客户的操作");
        System.out.println("------------------------修改客户---------------------");
        Customer cust;
        int number;
        for(;;){
            System.out.println("请选择待修改客户编号(-1退出)：");
            number = CMUUtility.readInt();

            if(number == -1){
                return;
            }
            cust = customerlist.getCustomer(number - 1);
            if(cust == null){
                System.out.println("无法找到指定客户");
            }else{//找到相应的编码的客户
                break;
            }
        }
        //修改客户信息
        System.out.print("姓名（" + cust.getName() + "):");
        String name = CMUUtility.readString(10,cust.getName());
        System.out.print("性别（" + cust.getGender() + "):");
        char gender = CMUUtility.readChar(cust.getGender());
        System.out.print("年龄（" + cust.getAge() + "):");
        int age = CMUUtility.readInt(cust.getAge());
        System.out.print("电话（" + cust.getPhone() + "):");
        String phone = CMUUtility.readString(13,cust.getPhone());
        System.out.print("邮箱（" + cust.getEmail() + "):");
        String email = CMUUtility.readString(30,cust.getEmail());

        Customer newcust = new Customer(name,gender,age,phone,email);

        boolean isRepalced = customerlist.replaceCustomer(number - 1, newcust);
        if(isRepalced){
            System.out.println("------------------------修改完成---------------------");
        }else{
            System.out.println("------------------------修改失败---------------------");
        }
    }

    /**
     * 删除客户的操作
     */
    private void deleteCustomer(){
        //System.out.println("删除客户列表的操作");
        System.out.println("------------------------删除客户---------------------");
        int number;
        for(;;){
            System.out.println("请选择删除客户编号(-1退出)");
            number = CMUUtility.readInt();

            if(number == -1){
                return;
            }
            Customer customer = customerlist.getCustomer(number-1);
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }
        }
        //找到了指定的客户
        System.out.print("确认是否删除（Y/N）");
        char isDelete = CMUUtility.readConfirmSelection();
        if(isDelete == 'Y'){
            boolean deleteSuccess = customerlist.deleteCustomer(number - 1);
            if(deleteSuccess){
                System.out.println("------------------------删除成功---------------------");
            }else{
                System.out.println("------------------------删除失败---------------------");

            }
        }else{
            return;
        }

    }

    /**
     *显示客户列表的操作
     */
    private void listAllCustomers(){
//        System.out.println("显示客户列表的操作");
        System.out.println("-------------------------客户列表---------------------\n");

        int total = customerlist.getTotal();
        if(total == 0){
            System.out.println("没有客户记录");

        }else{
            System.out.println(("编号\t姓名\t性别\t年龄\t电话\t邮箱"));
            Customer[] custs = customerlist.getAllCustomers();
            for(int i = 0;i < custs.length;i++){
                Customer cust = custs[i];
                System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()+"\t"+cust.getAge()+"\t"+cust.getEmail()+"\t"+cust.getPhone()+"\t"+cust.getEmail());
            }
        }

        System.out.println("-------------------------客户列表完成-----------------");
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
