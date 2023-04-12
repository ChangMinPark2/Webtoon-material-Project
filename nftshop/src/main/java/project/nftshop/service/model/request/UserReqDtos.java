package project.nftshop.service.model.request;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserReqDtos {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class CREATE{

        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
        private String identity;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String password;

        @NotBlank(message = "확인 비밀번호를 입력해주세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String checkPassword;

        @NotBlank(message = "생년 월일 입력해주세요")
        private String birth;

        @NotBlank(message = "이름을 입력해주세요")
        private String name;

        @NotBlank(message = "전화 번호를 입력해주세요")
        private String cellphone;

        @NotBlank(message = "이메일을 입력해주세요")
        private String email;

        @NotBlank(message = "성별을 입력해주세요")
        private String gender;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class DELETE{

        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
        private String identity;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String password;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class SIGNIN{

        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
        private String identity;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String password;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class UPDATE{

        @NotBlank(message = "아이디를 입력하세요.")
        @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
        private String identity;

        @NotBlank(message = "비밀번호를 입력하세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String password;

        @NotBlank(message = "생년 월일 입력해주세요")
        private String birth;

        @NotBlank(message = "이름을 입력해주세요")
        private String name;

        @NotBlank(message = "전화 번호를 입력해주세요")
        private String cellphone;

        @NotBlank(message = "이메일을 입력해주세요")
        private String email;

        @NotBlank(message = "성별을 입력해주세요")
        private String gender;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class PASSWORDUPDATE{

        @NotBlank(message = "아이디를 입력해주세요.")
        @Size(min = 5, max = 15, message = "아이디는 5~15자를 입력해주세요.")
        private String identity;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String password;

        @NotBlank(message = "새 비밀번호를 입력하지 않으셨습니다.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String newPassword;

        @NotBlank(message = "확인 비밀번호를 입력하지 않으셨습니다.")
        @Size(min = 5, max = 15, message = "비밀번호는 5~15자를 입력해주세요.")
        private String checkPassword;
    }
}
