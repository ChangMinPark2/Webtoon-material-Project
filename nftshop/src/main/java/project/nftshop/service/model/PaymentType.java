package project.nftshop.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PaymentType {

    CARD("카드"),
    KAKAO("카카오페이");

    String paymentType;

    public static PaymentType of(String paymentType){
        return Arrays.stream(PaymentType.values())
                .filter(g -> g.toString().equals(paymentType))
                .findAny().orElseThrow(() -> new RuntimeException("해당 결제 방식은 없습니다."));
    }
}
