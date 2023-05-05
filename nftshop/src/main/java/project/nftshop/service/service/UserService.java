package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.infra.error.exception.*;
import project.nftshop.persistence.entity.User;

import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.persistence.repository.UserRepository;
import project.nftshop.service.model.mapper.UserMapper;
import project.nftshop.service.model.request.*;
import project.nftshop.service.model.response.UserResDtos;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    /**
     * create user service
     * 회원가입 기능
     * */
    @Transactional
    public void createUser(UserReqDtos.CREATE create){

        checkIdentity(create.getIdentity());
        checkCellPhone(create.getCellphone());
        checkPassword(create.getPassword(), create.getCheckPassword());

        final User user = userMapper.toUserEntity(create);

        userRepository.save(user);
    }

    /**
     * signIn user service
     * 로그인 기능, ResponseFormat을 통해 로그인을 했을 경우 성공알림을 처리해줌.
     * */
    @Transactional
    public void signIn(UserReqDtos.SIGNIN signIn){

        final User user = userRepository.findByIdentity(signIn.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), signIn.getPassword());

    }

    public UserResDtos.READ readUser(String identity){

        final User user = userRepository.findByIdentity(identity)
                .orElseThrow(() -> new UserNotFoundException());

        return userMapper.toReadDto(user);
    }

    /**
     * update user survice
     * 사용자 정보 수정, User 엔티티 안에서 메소드를 호출함으로써 변경.
     * */
    @Transactional
    public void updateUser(UserReqDtos.UPDATE update){

        User user = userRepository.findByIdentity(update.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), update.getPassword());

        user.updateUser(update);
        userRepository.save(user);

    }

    /**
     * password update user service
     * 로그인 이후 새비밀번호와 확인 비밀번호 체크
     * */
    @Transactional
    public void passwordUpdate(UserReqDtos.PASSWORDUPDATE passwordUpdate){

        User user = userRepository.findByIdentity(passwordUpdate.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), passwordUpdate.getPassword());
        checkPassword(passwordUpdate.getNewPassword(), passwordUpdate.getCheckPassword());

        user.updatePassword(passwordUpdate);
        userRepository.save(user);
    }

    /**
     * delete user service
     * 회원삭제 기능
     * */
    @Transactional
    public void deleteUser(UserReqDtos.DELETE delete){

        final User user = userRepository.findByIdentity(delete.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPasswordMatch(user.getPassword(), delete.getPassword());

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
