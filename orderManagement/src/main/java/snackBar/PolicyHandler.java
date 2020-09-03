package snackBar;

import snackBar.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    //수정
    @Autowired
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrdered_Cook(@Payload Ordered ordered){
        //주문이 들어오고 주문관리를 통해 고객이 요청한 food list 알람전송
        if(ordered.isMe()){
            Cooking cooking = new Cooking();
            cooking.setClientId(ordered.getId()); // 주문번호, 처리구분을 위한 'Correlation key'
            cooking.setFoodStatus("Ready"); // 음식완료 상태
            cooking.setFoodList(ordered.getFoodList()); // 음식목록

            cookingRepository.save(cooking);

            System.out.println("##### listener Cook : " + ordered.toJson());
        }
    }

}
