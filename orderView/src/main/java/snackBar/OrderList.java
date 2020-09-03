package snackBar;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OrderList_table")
public class OrderList {

    private String foodList;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long clientId;
    private Long orderNum;
    private String foodStatus;


    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }
    public String getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(String foodStatus) {
        this.foodStatus = foodStatus;
    }

}
