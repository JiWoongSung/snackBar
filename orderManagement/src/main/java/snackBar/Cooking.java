package snackBar;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Cooking_table")
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNum; //주문번호 or 주문순서
    private String foodList;
    private String foodStatus;
    private Long clientId; // 고객번호

    @PostPersist
    public void onPostPersist() {
        Cooked cooked = new Cooked();
        BeanUtils.copyProperties(this, cooked);
        cooked.publishAfterCommit();

    }


    public Long getOrderNum() {
        return orderNum;
    }

    public void setorderNum(Long orderNum) {
        this.orderNum = orderNum ;
    }

    public long getClientId() {
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
