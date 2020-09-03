package snackBar;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Cancellation_table")
public class Cancellation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long clientId;
    private String foodList;
    private String orderStatus;


    @PostRemove
    public void onPostRemove(){
        CookingCanceled cookingCanceled = new CookingCanceled();
        BeanUtils.copyProperties(this, cookingCanceled);
        cookingCanceled.publishAfterCommit();
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

    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
