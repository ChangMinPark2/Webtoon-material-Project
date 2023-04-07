package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.nftshop.service.model.request.CreateUserDto;
import project.nftshop.service.model.request.DeleteUserDto;
import project.nftshop.service.service.UserService;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody @Valid CreateUserDto createUserDto){
        userService.createUser(createUserDto);
    }

    @DeleteMapping("/api/v1/user/myPage")
    public void deleteUser(@RequestBody @Valid DeleteUserDto deleteUserDto){
        userService.deleteUser(deleteUserDto);
    }
}
