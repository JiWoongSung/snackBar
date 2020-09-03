
package snackBar;

public class Cooked extends AbstractEvent {
    //kafka 이벤트 출력
    private Long orderNum;
    private String foodList;
    private String foodStatus;
    private long clientId;

    public Long getOrderNum() {
        return orderNum;
    }
    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
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

    public long getClientId() {
        return clientId;
    }
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
