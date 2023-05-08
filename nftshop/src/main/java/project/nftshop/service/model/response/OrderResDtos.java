package project.nftshop.service.model.response;

import lombok.*;
import java.time.LocalDate;
import java.util.List;


public class OrderResDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ{

        private String paymentType;

        private LocalDate paymentDate;

        private int totalPrice;

        private List<String> productsName;
    }
}
