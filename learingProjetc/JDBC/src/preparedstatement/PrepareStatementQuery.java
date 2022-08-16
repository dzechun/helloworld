package preparedstatement;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用preparedStatement实现针对于不同表的通用的查询操作
 */
public class PrepareStatementQuery {

    @Test
    public void testGetList(){
        String sql = "select customer_id,customer_name,salary,age from customer where customer_id < ?";
        List<Customer> customerList = getInstanceList(Customer.class, sql, 5);
        customerList.forEach(System.out::println);
    }


    public <T> List<T> getInstanceList(Class<T> clazz,String sql,Object ...args ){
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
//            创建集合对象
            ArrayList<T> ts = new ArrayList<>();
            while(rs.next()){
                T t = clazz.getDeclaredConstructor().newInstance();
                //            处理一行结果集一行数据的每一列
                for(int i = 0;i < columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

                    //                获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
//                    获取每个列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //                给customer指定的某个属性赋值为value

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                ts.add(t);
            }
            return ts;
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
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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

    @Test
    public void testGetInstance(){
        String sql = "select customer_id,customer_name,salary,age from customer where customer_id = ?";
        Customer customer = getInstance(Customer.class, sql, 1);
        System.out.println(customer);
    }

    public <T> T getInstance(Class<T> clazz,String sql,Object ...args){
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
                T t = clazz.getDeclaredConstructor().newInstance();
                //            处理一行结果集一行数据的每一列
                for(int i = 0;i < columnCount;i++){
                    Object columnValue = rs.getObject(i + 1);

                    //                获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
//                    获取每个列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //                给customer指定的某个属性赋值为value

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                return t;
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
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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
