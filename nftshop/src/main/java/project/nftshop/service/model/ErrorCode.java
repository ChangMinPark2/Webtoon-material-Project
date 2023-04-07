package project.nftshop.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SUCCESS_NULL(200, "실행이 성공했고, 응답 데이터는 없습니다."),
    SUCCESS_VALUE(200, "실행이 성공했고, 응답 데이터는 있습니다."),
    FAIL_NULL(400,"실행실패입니다."),
    //user
    USER_DUPLICATE(400, "회원 아이디가 중복되었습니다."),
    USER_NOT_FOUND(400, "해당 회원을 찾을 수 없습니다.");

    private int status;

    private String message;
}
