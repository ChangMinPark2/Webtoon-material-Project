package project.nftshop.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ResponseFormat <T>{
    //result => true : 응답 성공 , false : 응답 실패
    private boolean result;

    //data : 성공 시, 전달할 데이터
    private T data;

    //성공 혹은 실패 에 따른 설명 메시지
    private String message;

    //응답 코드
    //2XX : 성공
    //4XX : 실패
    private int status;

    public static ResponseFormat ok(){
        return ResponseFormat.builder()
                .result(true)
                .data(null)
                .message(ErrorCode.SUCCESS_NULL.getMessage())
                .status(ErrorCode.SUCCESS_NULL.getStatus())
                .build();
    }
    public static <T> ResponseFormat ok(T data){
        return ResponseFormat.builder()
                .result(true)
                .data(data)
                .message(ErrorCode.SUCCESS_VALUE.getMessage())
                .status(ErrorCode.SUCCESS_VALUE.getStatus())
                .build();
    }

    public static <T> ResponseFormat ok(String message){
        return ResponseFormat.builder()
                .result(true)
                .data(null)
                .message(message)
                .status(ErrorCode.SUCCESS_VALUE.getStatus())
                .build();
    }

    public static ResponseFormat fail(String message){
        return ResponseFormat.builder()
                .result(false)
                .data(null)
                .message(ErrorCode.FAIL_NULL.getMessage())
                .status(ErrorCode.FAIL_NULL.getStatus())
                .build();
    }
}
