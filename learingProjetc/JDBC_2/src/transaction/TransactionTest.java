package transaction;

import org.junit.Test;
import utils.JDBCUtils;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * 数据库事务：
 * 事务：一组逻辑操作单元，使数据从一种状态变换到另一种状态
 *      >一组逻辑操作单元：一个或多个DML操作
 */

public class TransactionTest {

    /**
     * 针对于数据表user_table来说：
     * AA用户给BB用户转账
     */
    @Test
    public void testUpdateCommon() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //            取消数据的自动提交
            conn.setAutoCommit(false);

            String sql1 = "update user set balance = balance - 100 where user = ?;";
            update(conn, sql1, "AA");


//            模拟网络异常
            System.out.println(1 / 0);

            String sql2 = "update user set balance = balance + 100 where user = ?;";
            update(conn, sql2, "BB");

            System.out.println("转账成功");

//            提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
//            回滚数据
            try {
                conn.rollback();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        } finally {
            JDBCUtils.closeConnection(conn, null);
        }

    }


    @Test
    public void testUpdate() throws SQLException {

        String sql1 = "update user set balance = balance - 100 where user = ?;";
        int aa = update(sql1, "AA");

        String sql2 = "update user set balance = balance + 100 where user = ?;";
        int bb = update(sql2, "BB");

        System.out.println("转账成功");
    }

    //    通用的增删改操作---version 1.0
    public int update(String sql, Object... args) {
//       1 获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
//       2 预编译sql语句，返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
//       3 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
//      4  执行
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(conn, ps);
        }
        return 0;
    }

    //    通用的增删改操作---version 2.0（考虑上事务）
    public int update(Connection conn, String sql, Object... args) {
//       1 获取数据库连接

        PreparedStatement ps = null;
        try {
//       2 预编译sql语句，返回PreparedStatement实例
            ps = conn.prepareStatement(sql);
//       3 填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
//      4  执行
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException d) {
                d.printStackTrace();
            }
            JDBCUtils.closeConnection(null, ps);
        }
        return 0;
    }


//    ************************************************************************

    @Test
    public void testTransactionSelect() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn.getTransactionIsolation());
//        设置数据库隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        System.out.println(conn.getTransactionIsolation());
//        取消数据自动提交
        conn.setAutoCommit(false);
        String sql = "select user,balance from user where user = ?;";
        User user = getInstance(conn, User.class, sql, "AA");
        System.out.println(user);
    }

    @Test
    public void testTransactionUpdate() throws InterruptedException, SQLException {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn.getTransactionIsolation());
        conn.setAutoCommit(false);
        String sql = "update user set balance = ? where user = ?;";
        int update = update(conn, sql, 2000,"AA");

        Thread.sleep(15000);
        System.out.println("修改成功");
    }

    //    通过的查询操作，用于返回数据表的一条记录(version 2.0:考虑上事务)
    public <T> T getInstance(Connection conn, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
//        获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
//        通过结果集的元数据获取列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                //            处理一行结果集一行数据的每一列
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);

                    //                获取每个列的列名
//                    String columnName = rsmd.getColumnName(i + 1);
//                    获取每个列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //                给customer指定的某个属性赋值为value

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnValue);
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
                JDBCUtils.closeConnection(null, ps, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }


}
