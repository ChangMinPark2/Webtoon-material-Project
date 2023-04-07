package project.nftshop.service.model.request;

import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PasswordUpdateUserDto {

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
