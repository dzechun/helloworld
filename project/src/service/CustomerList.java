/*项目要求：
*1.至少独立完成一遍以上的项目代码
* 2.基类完成项目的过程中常见的bug的调试
*   方式一：“硬”看，必要时添加输出语句。
*   方式二：Debug
* 3.捋顺思路，强化逻辑。
* 4.对象、数组等内存结构的解析
* 5.遵守编码的规范，标识符的命名规范等
* 6.在类前，方法前，方法内具体逻辑的实现步骤等添加必要的注释
 */

package service;

import learning8.bean.Customer;

public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total = 0;//记录已保存客户对象的数量
/*
用来初始化customers数组的构造器
totalCustomer,指定数组的长度
 */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    /*
    将指定的客户添加到数组中
    true：添加成功，false：添加失败
     */


    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        //customers[total++] = customer;
        //total++;
        customers[total++] = customer;
        return true;
    }

    /**
     * 修改指定索引位置的客户信息
     * @param index
     * @param cust
     * @return ture:修改成功 false:修改失败
     */
    public boolean replaceCustomer(int index, Customer cust){

        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 删除指定索引位置上的客户
     * @param index
     * @return true:删除成功 false:删除失败
     */

    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for(int i = index;i < total - 1;i++){
            customers[i] = customers[i + 1];
        }
        //最后有数据的元素需要置空
        customers[total - 1] = null;
        total--;
        return true;
    }

    /**
     * 获取所有的客户信息
     * @param
     * @return
     */
    public Customer[] getAllCustomers(){
//        return customers;

        Customer[] custs = new Customer[total];
        for(int i = 0;i < total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 获取指定索引位置上的客户
     * @param index
     * @return 如果找到了元素，则返回；如果没有找到，则返回null
     */
    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    /**
     * 获取存储的客户的数量
     */
    public int getTotal(){
        return total;
    }
}
