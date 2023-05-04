package project.nftshop.service.model.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
