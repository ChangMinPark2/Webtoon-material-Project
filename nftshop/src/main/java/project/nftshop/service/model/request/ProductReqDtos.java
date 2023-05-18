package project.nftshop.service.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.persistence.entity.ImageFile;

public class ProductReqDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class CREATE{

        private String identity;

        private String password;

        private String productsNames;

        private String description;

        private int price;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UPDATE{

        private String productsNames; //

        private String description;

        private int price;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class DELETE{
        private String productsNames;
    }
}
