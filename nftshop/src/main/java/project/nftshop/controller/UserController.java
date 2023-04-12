package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.*;
import project.nftshop.service.model.response.UserResDtos;
import project.nftshop.service.service.UserService;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseFormat createUser(@RequestBody @Valid UserReqDtos.CREATE create){
        userService.createUser(create);
        return ResponseFormat.ok();
    }

    @PostMapping("/logIn")
    public ResponseFormat signIn(@RequestBody @Valid UserReqDtos.SIGNIN signin){
        userService.signIn(signin);
        return ResponseFormat.ok("로그인 성공");
    }

    @GetMapping("/{identity}")
    public ResponseFormat<UserResDtos.READ> readUser(@PathVariable(name = "identity") String identity){
        return ResponseFormat.ok(userService.readUser(identity));
    }

    @DeleteMapping("/myPage")
    public ResponseFormat deleteUser(@RequestBody @Valid UserReqDtos.DELETE delete){
        userService.deleteUser(delete);
        return ResponseFormat.ok();
    }

    @PutMapping("/myPage/passwordUpdate")
    public ResponseFormat passwordUpdate(@RequestBody @Valid UserReqDtos.PASSWORDUPDATE passwordUpdate){
        userService.passwordUpdate(passwordUpdate);
        return ResponseFormat.ok();
    }

    @PutMapping("/myPage")
    public ResponseFormat updateUser(@RequestBody @Valid UserReqDtos.UPDATE update){
        userService.updateUser(update);
        return ResponseFormat.ok();
    }
}
