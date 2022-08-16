package learning16;

public class Order {
    private int orderId;
    private String orderName;

    public Order(){}

    public Order(int orderId,String orderName){
        this.orderName = orderName;
        this.orderId = orderId;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public void setOrderName(String orderName){
        this.orderName = orderName;
    }

    public int getOrderId(){
        return this.orderId;
    }

    public String getOrderName(){
        return this.orderName;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Order){
            Order order = (Order) obj;
            if(this.orderId == order.orderId && this.orderName.equals(order.orderName)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Order o1 = new Order(1,"n");
        Order o2 = new Order(2,"m");
        System.out.println(o1.equals(o2));

        Order o3 = new Order(3,"a");
        Order o4 = new Order(3,"a");
        System.out.println(o3.equals(o4));
    }
}


