package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.persistence.entity.User;
import project.nftshop.persistence.repository.UserRepository;
import project.nftshop.service.model.request.CreateUserDto;
import project.nftshop.service.model.request.DeleteUserDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(CreateUserDto createUserDto){

        final User userBuild = User.createOf(createUserDto);

        userRepository.save(userBuild);
    }

    @Transactional
    public void deleteUser(DeleteUserDto deleteUserDto){

        final User user = userRepository.findByIdentity(deleteUserDto.getIdentity())
                .orElseThrow(() -> new RuntimeException("Not Found User"));

        userRepository.delete(user);
    }
}
