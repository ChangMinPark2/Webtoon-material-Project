package project.nftshop.service.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class OrderReqDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class CREATE{

        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
        private String identity;

        @NotBlank(message = "need a petType")
        private String paymentType;

        @NotEmpty(message = "need a productName")
        private Set<String> productsName;
    }
}
