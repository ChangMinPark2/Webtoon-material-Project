package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.nftshop.infra.error.model.ErrorCodeType;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.*;
import project.nftshop.service.model.response.UserResDtos;
import project.nftshop.service.service.UserService;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseFormat<Void> createUser(@RequestBody @Valid UserReqDtos.CREATE create){
        userService.createUser(create);
        return ResponseFormat.ok();
    }

    @PostMapping("/logIn")
    public ResponseFormat<Void> signIn(@RequestBody @Valid UserReqDtos.SIGNIN signIn){

        userService.signIn(signIn);
        return ResponseFormat.ok();
    }

    @GetMapping("/myPage")
    public ResponseFormat<UserResDtos.READ> readUser(@RequestParam (name = "identity") String identity){
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
