package pl.dezet.library.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dezet.library.model.User;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @RequestMapping("user")
    public User user(@AuthenticationPrincipal User principal) {
        return principal;
    }
}
