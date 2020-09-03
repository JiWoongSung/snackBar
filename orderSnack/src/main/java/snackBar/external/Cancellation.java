package snackBar.external;

public class Cancellation {

    private Long clientId;
    private String foodList;
    private String orderStatus;

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFoodList() {
        return foodList;
    }
    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
