
package snackBar;

public class Cooked extends AbstractEvent {

    private Long id;
    private Long orderNum;
    private Long clientId;
    private String foodList;
    private String foodStatus;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

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

    public String getFoodStatus() {
        return foodStatus;
    }
    public void setFoodStatus(String foodStatus) {
        this.foodStatus = foodStatus;
    }

}
