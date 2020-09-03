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

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCooked_SendNotification(@Payload Cooked cooked){

        if(cooked.isMe()){
            System.out.println("##### 주문접수완료 : " + cooked.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCookingCanceled_SendNotification(@Payload CookingCanceled cookingCanceled){

        if(cookingCanceled.isMe()){
            System.out.println("##### 주문접수취소 : " + cookingCanceled.toJson());
        }
    }

}
