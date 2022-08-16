package DAO;

import org.junit.Test;
import utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 封装了针对于数据表通用的操作
 */
public abstract class BaseDAO {

    //通用增删改操作（version2.0：考虑上事务）
    public int update(Connection conn,String sql,Object ...args) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(null,ps);
        }
        return 0;
    }

    //通用查询操作,用于返回数据表中多条记录构成的集合（version2.0：考虑上事务）
    public <T> List<T> getInstanceList(Connection conn,Class<T> clazz,String sql,Object ...args ){

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
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
        } catch (Exception e) {
           e.printStackTrace();
        }finally {
            try {
                JDBCUtils.closeConnection(null,ps,rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Test
    public void testGetInstance(){
        Connection conn = JDBCUtils.getConnection();
        String sql = "select customer_id,customer_name,salary,age from customer where customer_id = ?";
        Customer customer = getInstance(conn,Customer.class, sql, 1);
        System.out.println(customer);
    }

    public <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            ps = conn.prepareStatement(sql);
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.closeConnection(null,ps,rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

//    查询特殊值通用方法
    public <T> T getValue(Connection conn,String sql,Object ...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return (T) rs.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(null,ps,rs);
        }
        return null;
    }

}
