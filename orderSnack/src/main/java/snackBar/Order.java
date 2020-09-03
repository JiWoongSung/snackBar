package snackBar;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Order_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String foodList;
    private String orderStatus;

    @PostPersist
    public void onPostPersist(){
        Ordered ordered = new Ordered();
        BeanUtils.copyProperties(this, ordered);
        ordered.publishAfterCommit();


    }

    @PostRemove
    public void onPostRemove(){
//        OrderCanceled orderCanceled = new OrderCanceled();
//        BeanUtils.copyProperties(this, orderCanceled);
//        orderCanceled.publishAfterCommit();

//        //동기식 호출 ,고객에게 취소요청을 받은 직후 주문을 취소
        snackBar.external.Cancellation cancellation = new snackBar.external.Cancellation();
        // mappings goes here

        cancellation.setClientId(getId());
        cancellation.setFoodList(getFoodList());
        cancellation.setOrderStatus("Cancel");


        OrderSnackApplication.applicationContext.getBean(snackBar.external.CancellationService.class).cancel(cancellation);

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
