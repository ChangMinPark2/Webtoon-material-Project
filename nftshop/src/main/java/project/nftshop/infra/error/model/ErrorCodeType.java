package project.nftshop.infra.error.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeType {

    SUCCESS_NULL("실행이 성공했고, 응답 데이터는 없습니다.", 200),
    SUCCESS_VALUE("실행이 성공했고, 응답 데이터는 있습니다.", 400),
    FAIL_NULL("실행실패입니다.", 400),
    //user
    USER_DUPLICATE("회원 아이디가 중복 되었습니다.", 400),
    USER_NOT_FOUND("회원이 존재하지 않습니다.", 400),
    WRONG_CHECK_PASSWORD("비밀번호와 확인 비밀번호가 다릅니다.", 400),
    WRONG_PASSWORD("비밀번호가 틀렸습니다.", 400),
    DUPLICATED_CELLPHONE("중복된 전화번호 입니다.", 400),
    DUPLICATED_PRODUCT_NAME("중복된 상품 이름 입니다.", 400),

    RUNTIME_EXCEPTION("RUNTIME-EXCEPTION", 400),

    NOT_FOUND("not found", 400);

    private String message;

    private int status;

}
