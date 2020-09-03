package snackBar;

import snackBar.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderListViewHandler {


    @Autowired
    private OrderListRepository orderListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCooked_then_CREATE_1 (@Payload Cooked cooked) {
        try {
            if (cooked.isMe()) {
                // view 객체 생성
                OrderList orderList = new OrderList();
                // view 객체에 이벤트의 Value 를 set 함
                orderList.setClientId(cooked.getClientId());
                orderList.setFoodList(cooked.getFoodList());
                orderList.setOrderNum(cooked.getOrderNum());
                orderList.setFoodStatus(cooked.getFoodStatus());
                // view 레파지 토리에 save
                orderListRepository.save(orderList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_DELETE_1(@Payload Canceled canceled) {
        try {
            if (canceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                orderListRepository.deleteById(canceled.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}