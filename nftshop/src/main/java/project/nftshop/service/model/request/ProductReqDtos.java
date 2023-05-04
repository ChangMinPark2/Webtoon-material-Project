package project.nftshop.service.model.request;

import lombok.*;

public class ProductReqDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class CREATE{

        private String productsNames;

        private String description;

        private int price;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UPDATE{

        private Long productId;

        private String productsNames;

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
