package snackBar;

public class Canceled extends AbstractEvent {

    private Long clientId;
    private String orderStatus;
    private String foodList;

    public Long getId() {
        return clientId;
    }

    public void setId(Long clientId) {
        this.clientId = clientId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }
}