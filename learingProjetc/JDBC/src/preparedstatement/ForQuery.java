package preparedstatement;

import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.sql.PreparedStatement;


/**
 * ORM编程思想
 * 一个数据表对应一个java类
 * 表中的一条记录对应Java类的一个对象
 * 表中的一个字段对应Java类的一个属性
 */
public class ForQuery {
    @Test
    public void testQueryForCustomer(){
        String sql = "select customer_id,customer_name,salary,age from customer where customer_id = ?";
        Customer customer = testForQuery(sql, 1);
        System.out.println(customer);


    }
    /**
     * 针对于customer表的通用的查询操作
     * 1.必须声明sql时，使用类的属性名来命名字段的别名
     * 2.使用resultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),获取列的别名、
     * 说明：如果sql中没有给字段起别名，getColumnLabel()获取的就是列名
     */

    public Customer testForQuery(String sql, Object ...args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();
            ps = con.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
//        获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
//        通过结果集的元数据获取列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()){
                Customer customer = new Customer();
    //            处理一行结果集一行数据的每一列
                for(int i = 0;i < columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

    //                获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
//                    获取每个列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //                给customer指定的某个属性赋值为value

                    Field declaredField = Customer.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(customer,columnValue);
                }
                return customer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeConnection(con,ps,rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
