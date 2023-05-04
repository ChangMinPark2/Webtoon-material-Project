package project.nftshop.service.model.response;

import lombok.*;

public class ProductResDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ {

        private String productsNames;

        private String description;

        private int price;
    }
}
