package project.nftshop.infra.error.model;

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
    USER_NOT_FOUND(400, "해당 회원을 찾을 수 없습니다."),
    WRONG_CHECK_PASSWORD(400, "비밀번호와 확인 비밀번호가 다릅니다."),
    WRONG_PASSWORD(400, "비밀번호가 틀렸습니다."),
    DUPLICATED_CELLPHONE(400, "중복된 전화번호 입니다.");

    private int status;

    private String message;
}
