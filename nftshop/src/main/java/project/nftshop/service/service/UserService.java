package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.persistence.entity.User;
import project.nftshop.persistence.repository.UserRepository;
import project.nftshop.service.model.ResponseFormat;
import project.nftshop.service.model.exception.*;
import project.nftshop.service.model.request.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    /**
     * create user service
     * 회원가입 기능
     * */
    @Transactional
    public void createUser(SignUpUserDto createUserDto){

        checkIdentity(createUserDto.getIdentity());
        checkCellPhone(createUserDto.getCellphone());
        checkPassword(createUserDto.getPassword(), createUserDto.getCheckPassword());

        final User userBuild = User.createOf(createUserDto);

        userRepository.save(userBuild);
    }

    /**
     * signIn user service
     * 로그인 기능, ResponseFormat을 통해 로그인을 했을 경우 성공알림을 처리해줌.
     * */
    @Transactional
    public void signIn(SignInUserDto signInUserDto){

        final User user = userRepository.findByIdentity(signInUserDto.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), signInUserDto.getPassword());
        ResponseFormat.ok(user);
    }

    /**
     * update user survice
     * 사용자 정보 수정, User 엔티티 안에서 메소드를 호출함으로써 변경.
     * */
    @Transactional
    public void updateUser(UpdateUserDto updateUserDto){

        User user = userRepository.findByIdentity(updateUserDto.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), updateUserDto.getPassword());

        user.updateUser(updateUserDto);
        userRepository.save(user);

    }

    /**
     * password update user service
     * 로그인 이후 새비밀번호와 확인 비밀번호 체크
     * */
    @Transactional
    public void passwordUpdate(PasswordUpdateUserDto passwordUpdateUserDto){

        User user = userRepository.findByIdentity(passwordUpdateUserDto.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), passwordUpdateUserDto.getPassword());
        checkPassword(passwordUpdateUserDto.getNewPassword(), passwordUpdateUserDto.getCheckPassword());

        user.updatePassword(passwordUpdateUserDto);
        userRepository.save(user);
    }

    /**
     * delete user service
     * 회원삭제 기능
     * */
    @Transactional
    public void deleteUser(DeleteUserDto deleteUserDto){

        final User user = userRepository.findByIdentity(deleteUserDto.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), deleteUserDto.getPassword());

        userRepository.delete(user);
    }


    /**
     * 아이디 중복체크 메소드
     * */
    private void checkIdentity(String identity){
        if (userRepository.existsByIdentity(identity))
            throw new UserIdDuplicatedException();
    }

    /**
     * 전화번호 중복체크 메소드
     * */
    private void checkCellPhone(String cellphone){
        if (userRepository.existsByCellphone(cellphone))
            throw new DuplicatedCellphoneException();
    }
    /**
     * 비밀번호, 확인 비밀번호 일치 메소드
     */
    private void checkPassword(String password, String checkPassword){
        if (!password.equals(checkPassword))
            throw new WrongCheckPasswordException();
    }

    /**
     * 저장된 비밀번호와, 입력받은 비밀번호의 일치 메소드
     * */
    private void checkPasswordMatch(String originPassword, String checkPassword){
        if(!originPassword.equals(checkPassword))
            throw new WrongPasswordException();
    }
}
