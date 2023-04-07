package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.nftshop.service.model.ResponseFormat;
import project.nftshop.service.model.request.*;
import project.nftshop.service.service.UserService;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseFormat createUser(@RequestBody @Valid SignUpUserDto createUserDto){
        userService.createUser(createUserDto);
        return ResponseFormat.ok();
    }

    @PostMapping("/logIn")
    public ResponseFormat signIn(@RequestBody @Valid SignInUserDto signInUserDto){
        userService.signIn(signInUserDto);
        return ResponseFormat.ok("로그인 성공");
    }

    @DeleteMapping("/myPage")
    public ResponseFormat deleteUser(@RequestBody @Valid DeleteUserDto deleteUserDto){
        userService.deleteUser(deleteUserDto);
        return ResponseFormat.ok();
    }

    @PutMapping("/myPage/passwordUpdate")
    public ResponseFormat passwordUpdate(@RequestBody @Valid PasswordUpdateUserDto passwordUpdateUserDto){
        userService.passwordUpdate(passwordUpdateUserDto);
        return ResponseFormat.ok();
    }

    @PutMapping("/myPage")
    public ResponseFormat updateUser(@RequestBody @Valid UpdateUserDto updateUserDto){
        userService.updateUser(updateUserDto);
        return ResponseFormat.ok();
    }
}
