package project.nftshop.service.model.response;

import lombok.*;

public class ImageFileResDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class READ {
        private String saveName;
    }
}
