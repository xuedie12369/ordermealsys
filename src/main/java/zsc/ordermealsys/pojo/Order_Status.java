package zsc.ordermealsys.pojo;

public class Order_Status {
    private Integer id;

    private String orderId;

    private Integer orderStatus;

    public Order_Status(Integer id, String orderId, Integer orderStatus) {
        this.id = id;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    public Order_Status() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}