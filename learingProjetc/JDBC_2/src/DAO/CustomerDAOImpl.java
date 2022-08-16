package DAO;

import java.sql.Connection;
import java.util.List;

public class CustomerDAOImpl extends BaseDAO implements CustomerDAO{
    @Override
    public void insert(Connection conn, Customer customer) {
        String sql = "insert into customer(customer_name,salary,age) values(?,?,?);";
        update(conn,sql,customer.getCustomer_name(),customer.getSalary(),customer.getAge());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customer where customer_id = ?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn, Customer customer) {
        String sql = "update customer set customer_name = ?,salary = ?,age = ? where customer_id = ?";
        update(conn,sql,customer.getCustomer_name(),customer.getSalary(),customer.getAge(),customer.getCustomer_id());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql = "select * from customer where customer_id = ?";
        Customer customer = getInstance(conn, Customer.class, sql, id);
        return customer;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql = "select * from";
        List<Customer> instanceList = getInstanceList(conn, Customer.class, sql);
        return instanceList;
    }

    @Override
    public long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn,sql);
    }

    @Override
    public String getCustomerName(Connection conn) {
        String sql = "select customer_name from customer";
        return getValue(conn,sql);
    }
}
