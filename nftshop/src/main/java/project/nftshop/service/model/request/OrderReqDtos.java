package project.nftshop.service.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
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

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String password;

        @NotBlank
        private String paymentType;

        @NotBlank
        private Set<String> productsName;
    }
}
