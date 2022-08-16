package preparedstatement;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用preparedStatement实现批量数据的操作
 *
 * update\delete本身就具有批量操作的效果
 * 使用preparedStatement如何实现更高效的批量插入
 *
 * 向goods表中插入20000条数据
 * 方式一：
 *
 * 插入方式三
 * 1.addBatch()\excuteBatch()\clearBatch()
 * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支援
 *      ?rewriteBatchedStatements=true 写在配置文件的url后面
 *
 */
public class InsertTest {

//    方式四
    @Test
    public void testInsert4() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            con = JDBCUtils.getConnection();

            //设置不允许自动提交数据
            con.setAutoCommit(false);

            String sql = "insert into goods(name) values(?)";
            ps = con.prepareStatement(sql);
            for(int i = 1;i < 1000000;i++){
                ps.setObject(1,"name_" + i);

    //                "攒"sql
                ps.addBatch();

                if(i % 500 == 0){
    //                    执行batch
                    ps.executeBatch();

    //                    清空batch
                    ps.clearBatch();
                }

            }
            con.commit();
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(con,ps);
        }

    }

//    批量插入的方式三
//    1.addBatch()
    @Test
    public void testInsert3() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            con = JDBCUtils.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for(int i = 1;i < 20000;i++){
                ps.setObject(1,"name_" + i);

//                "攒"sql
                ps.addBatch();

                if(i % 500 == 0){
//                    执行batch
                    ps.executeBatch();

//                    清空batch
                    ps.clearBatch();
                }

                ps.execute();

            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(con,ps);
        }

    }


//    方式二
    @Test
    public void testInsert2() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            con = JDBCUtils.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = con.prepareStatement(sql);
            for(int i = 1;i < 20000;i++){
                ps.setObject(1,"name_" + i);
                ps.execute();

            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(con,ps);
        }

    }
}
