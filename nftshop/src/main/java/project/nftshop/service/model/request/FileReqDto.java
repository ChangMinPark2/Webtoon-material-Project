package project.nftshop.service.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FileReqDto {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CREATE {

        private String fileName;

        private String saveName;

        private String contentType;
    }
}
