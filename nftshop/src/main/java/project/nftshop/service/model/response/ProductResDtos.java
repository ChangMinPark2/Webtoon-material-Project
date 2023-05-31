package project.nftshop.service.model.response;

import lombok.*;

import java.util.List;

public class ProductResDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ {

        private String productsNames;

        private String description;

        private int price;

        private String saveName;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ_SAVE_NAME{

        private String saveName;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ_TOP4{

        private String top1;

        private String top2;

        private String top3;

        private String top4;
    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ_ALL_PRODUCT_IMAGE{

        private String productsNames;

        private String saveName;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ_MY_PRODUCT{

        private String productsNames;

        private String saveName;
    }
}
