package project.nftshop.service.model.response;

import lombok.*;
import project.nftshop.service.model.Gender;

import java.util.List;

public class UserResDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ{

        private String identity;

        private String birth;

        private String name;

        private String cellphone;

        private String email;

        private Gender gender;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ_MY_PRODUCT{

        private List<String> productsNames;
    }
}
